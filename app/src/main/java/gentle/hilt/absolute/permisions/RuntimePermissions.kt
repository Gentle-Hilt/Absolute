package gentle.hilt.absolute.permisions

import android.Manifest
import android.app.AlertDialog
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import gentle.hilt.data.res.custom_composables.CustomAlertDialog
import gentle.hilt.data.res.strings.strings

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RuntimePermissions() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val permissionState = rememberPermissionState(Manifest.permission.POST_NOTIFICATIONS)
        val context = LocalContext.current
        when {
            !permissionState.status.shouldShowRationale && !permissionState.status.isGranted -> {
                //  Note that this dialog might not appear on the screen if the user doesn't want to be asked
                //     * again or has denied the permission multiple times.
                LaunchedEffect(key1 = Unit, block = {
                    permissionState.launchPermissionRequest()
                })
            }

            permissionState.status.shouldShowRationale -> {
                AlertDialog.Builder(context).CustomAlertDialog(
                    positiveText = strings.ok,
                    negativeText = strings.cancel,
                    title = strings.warning,
                    message = strings.notifications_permissions_ask_message,
                    onConfirm = { permissionState.launchPermissionRequest() }
                )
            }
        }
    }
}
