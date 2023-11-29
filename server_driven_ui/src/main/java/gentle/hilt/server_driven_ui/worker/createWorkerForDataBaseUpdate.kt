package gentle.hilt.server_driven_ui.worker

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

fun createWorkerForDataBaseUpdate(context: Context) {
    val workRequest = OneTimeWorkRequestBuilder<UpdateDataBaseWorker>().build()
    WorkManager.getInstance(context).enqueue(workRequest)
}


