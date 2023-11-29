package gentle.hilt.server_driven_ui.worker

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.server_driven_ui.R
import gentle.hilt.server_driven_ui.notifications.handleCustomMessageIntent
import gentle.hilt.server_driven_ui.notifications.handleSilentNotificationIntent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LaunchNotificationsWorker(
    val context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams), KoinComponent {
    private val dataStore: DataStoreManager by inject()
    private val intentUri = inputData.getString("intent")
    private val intent: Intent = Intent.parseUri(intentUri, Intent.URI_INTENT_SCHEME)
    private val notificationType = intent.getStringExtra("action")

    override suspend fun doWork() = withContext(Dispatchers.IO) {
        if (dataStore.readSilentUpdates.first() || notificationType == "silent") {
            createWorkerForDataBaseUpdate(context)
            handleSilentNotificationIntent(
                intent = intent,
                context = context,
                uniqueIdChannel = context.getString(R.string.fcm_silent),
                userReadableTitleInChannel = context.getString(R.string.fcm_silent_channel_name),
                channelImportance = NotificationManager.IMPORTANCE_LOW,
                notificationIcon = R.drawable.fcm_silent_icon
            )
            Result.success()
        } else {
            when (notificationType) {
                "update" -> {
                    createWorkerForDataBaseUpdate(context)
                    handleCustomMessageIntent(
                        intent = intent,
                        context = context,
                        uniqueIdChannel = context.getString(R.string.fcm_update_ui),
                        userReadableTitleInChannel = context.getString(R.string.ui_updates_channel_name),
                        channelImportance = NotificationManager.IMPORTANCE_DEFAULT,
                        notificationIcon = R.drawable.fcm_update_icon
                    )
                    Result.success()
                }
                "promotion" -> {
                    handleCustomMessageIntent(
                        intent = intent,
                        context = context,
                        uniqueIdChannel = context.getString(R.string.fcm_promotions),
                        userReadableTitleInChannel = context.getString(R.string.fcm_promotion_channel_name),
                        channelImportance = NotificationManager.IMPORTANCE_DEFAULT,
                        notificationIcon = R.drawable.fcm_promotion_icon
                    )
                    Result.success()
                }
                "secret" ->{
                    createWorkerForDataBaseUpdate(context)
                    Result.success()
                }
                else -> {
                    Result.failure()
                }
            }
        }

    }


}