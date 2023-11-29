package gentle.hilt.data.history

import kotlinx.coroutines.flow.Flow

class HistoryRepository(
    private val historyDao: HistoryDao
) {

    suspend fun addNewHistory(history: HistoryEntity) {
        historyDao.insertHistory(history)
    }

    suspend fun updateHistory(history: HistoryEntity){
        historyDao.updateHistory(history)
    }

    fun observeHistory(): Flow<HistoryEntity?> = historyDao.observeHistory()
}