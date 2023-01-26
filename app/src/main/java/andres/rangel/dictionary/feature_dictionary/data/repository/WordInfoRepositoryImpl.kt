package andres.rangel.dictionary.feature_dictionary.data.repository

import andres.rangel.dictionary.core.util.Resource
import andres.rangel.dictionary.feature_dictionary.data.local.WordInfoDao
import andres.rangel.dictionary.feature_dictionary.data.remote.DictionaryApi
import andres.rangel.dictionary.feature_dictionary.domain.model.WordInfo
import andres.rangel.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfo = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Loading(wordInfo))

        try {
            val remoteWordInfo = api.getWordInfo(word)
            dao.deleteWordInfo(remoteWordInfo.map { it.word })
            dao.insertWordInfo(remoteWordInfo.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    data = wordInfo,
                    message = "Oops, something went wrong!"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    data = wordInfo,
                    message = "Couldn't reach server, check your internet connection."
                )
            )
        }

        val newWordInfo = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}