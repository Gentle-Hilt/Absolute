package gentle.hilt.server_driven_ui.fmc

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import com.google.firebase.messaging.FirebaseMessagingService
import gentle.hilt.server_driven_ui.worker.createLaunchNotificationWorker
import gentle.hilt.server_driven_ui.worker.createWorkerForDataBaseUpdate
import org.koin.android.ext.android.inject
import timber.log.Timber

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class FireBaseCloudMessaging : FirebaseMessagingService() {
    val context: Context by inject()
    // Triggers UI updates from FCM notifications in the following cases:
    // - When the application is in the Foreground
    // - When the application is in the Background
    // - After the user was offline
    override fun handleIntent(intent: Intent) {
        val action = intent.action
        // RECEIVE is used to indicate that the incoming intent is related to receiving an FCM message
        // DIRECT_BOOT is used to indicate that the incoming intent is related to receiving an FCM message
        // during a mode that allows certain components to start running before the device is fully unlocked.
        if ("com.google.android.c2dm.intent.RECEIVE" != action && "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT" != action) {
            // If an FCM token has been generated or refreshed, call onNewToken
            if ("com.google.firebase.messaging.NEW_TOKEN" == action) {
                val token = intent.getStringExtra("token")
                Timber.d("$token")
                onNewToken(token ?: "")
            } else {
                Timber.d("FirebaseMessaging Unknown intent action: $action")
            }
        } else {
            createLaunchNotificationWorker(context, intent)
        }
    }

    // If the device hasn't connected to FCM in more than one month
    override fun onDeletedMessages() {
        super.onDeletedMessages()
        createWorkerForDataBaseUpdate(context)
    }
}

