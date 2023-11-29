package gentle.hilt.data.history

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gentle.hilt.data.converters.HistoryConverter


@Database(
    entities = [HistoryEntity::class],
    version = HistoryDataBase.HISTORY_DATABASE_VERSION
)
@TypeConverters(HistoryConverter::class)
abstract class HistoryDataBase: RoomDatabase() {
    abstract fun dao(): HistoryDao

    companion object {
        const val HISTORY_DATABASE_VERSION = 1
    }
}