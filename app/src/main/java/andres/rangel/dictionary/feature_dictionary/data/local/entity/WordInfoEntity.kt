package andres.rangel.dictionary.feature_dictionary.data.local.entity

import andres.rangel.dictionary.feature_dictionary.domain.model.Meaning
import andres.rangel.dictionary.feature_dictionary.domain.model.WordInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordInfoEntity(
    @PrimaryKey val id: Int? = null,
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>
) {
    fun toWordInfo() = WordInfo(
        meanings = meanings,
        phonetic = phonetic,
        word = word
    )
}
