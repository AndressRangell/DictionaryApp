package andres.rangel.dictionary.feature_dictionary.data.local

import andres.rangel.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase : RoomDatabase() {
    abstract val dao: WordInfoDao
}