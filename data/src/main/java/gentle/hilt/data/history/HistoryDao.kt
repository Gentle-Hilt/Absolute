package gentle.hilt.data.history

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(historyEntity: HistoryEntity)

    @Update
    suspend fun updateHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM history_table")
    fun observeHistory(): Flow<HistoryEntity?>
}