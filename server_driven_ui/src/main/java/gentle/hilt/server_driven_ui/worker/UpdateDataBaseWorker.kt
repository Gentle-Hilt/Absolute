package gentle.hilt.server_driven_ui.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import gentle.hilt.data.datastore.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class UpdateDataBaseWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams), KoinComponent {
    private val dataStore: DataStoreManager by inject()

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        Timber.d("Worker set trigger for updating DataBase to true")
        dataStore.saveShouldUpdateDataBase(true)
        Result.success()
    }
}
