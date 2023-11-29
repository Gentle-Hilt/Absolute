package gentle.hilt.server_driven_ui.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

fun handleCustomMessageIntent(
    intent: Intent,
    context: Context,
    uniqueIdChannel: String,
    userReadableTitleInChannel: String,
    channelImportance: Int,
    notificationIcon: Int
) {
    val notificationTitle = intent.getStringExtra("gcm.notification.title")
    val notificationMessage = intent.getStringExtra("gcm.notification.body")
    val notificationsId = System.currentTimeMillis().toInt()

    createNotificationChannel(uniqueIdChannel, userReadableTitleInChannel, channelImportance, context)

    val notificationIntent = Intent().setClassName(context.packageName, "gentle.hilt.absolute.SingleActivity")

    val pendingIntent = PendingIntent.getActivity(
        context,
        notificationsId,
        notificationIntent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val notificationBuilder = NotificationCompat.Builder(context, uniqueIdChannel)
        .setContentTitle(notificationTitle)
        .setContentText(notificationMessage)
        .setSmallIcon(notificationIcon)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.notify(notificationsId, notificationBuilder.build())
}