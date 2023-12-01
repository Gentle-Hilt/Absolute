package gentle.hilt.profile.screen.authentication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import gentle.hilt.profile.ProfileScreenVM

@Composable
fun authenticationLauncher(
    viewModel: ProfileScreenVM,
    context: Context = LocalContext.current
): ManagedActivityResultLauncher<Intent, ActivityResult> {

    return rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val response = IdpResponse.fromResultIntent(result.data)
        val errorCode = response?.error?.errorCode

        if (result.resultCode == Activity.RESULT_OK) {
            viewModel.updateCurrentUserState()
            Toast.makeText(context, "Signed In", Toast.LENGTH_SHORT).show()
        } else {
            when (errorCode) {
                ErrorCodes.ANONYMOUS_UPGRADE_MERGE_CONFLICT -> {
                    Toast.makeText(context, "Account linking Failed", Toast.LENGTH_SHORT).show()
                }

                ErrorCodes.NO_NETWORK -> {
                    Toast.makeText(context, "No Network", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
