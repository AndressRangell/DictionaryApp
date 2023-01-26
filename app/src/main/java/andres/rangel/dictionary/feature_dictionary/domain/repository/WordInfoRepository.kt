package andres.rangel.dictionary.feature_dictionary.domain.repository

import andres.rangel.dictionary.core.util.Resource
import andres.rangel.dictionary.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}