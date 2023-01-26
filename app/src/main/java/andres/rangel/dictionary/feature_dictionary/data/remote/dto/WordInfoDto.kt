package andres.rangel.dictionary.feature_dictionary.data.remote.dto

import andres.rangel.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import andres.rangel.dictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val word: String
) {
    fun toWordInfoEntity() = WordInfoEntity(
        meanings = meanings.map { it.toMeaning() },
        phonetic = phonetic,
        word = word
    )
}