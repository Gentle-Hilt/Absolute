package gentle.hilt.server_driven_ui.worker

import android.content.Context
import android.content.Intent
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager


fun createLaunchNotificationWorker(context: Context, intent: Intent) {
    val data = Data.Builder()
        .putString("intent", intent.toUri(Intent.URI_INTENT_SCHEME))
        .build()

    val workRequest = OneTimeWorkRequestBuilder<LaunchNotificationsWorker>()
        .setInputData(data)
        .build()
    WorkManager.getInstance(context).enqueue(workRequest)
}