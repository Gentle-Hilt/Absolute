package gentle.hilt.absolute.first_time_in_app

import androidx.lifecycle.LifecycleCoroutineScope
import com.google.firebase.auth.FirebaseAuth
import gentle.hilt.absolute.SingleActivity
import gentle.hilt.absolute.first_time_in_app.anonymous_authentication.anonymousAuthentication
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.datastore.MagicNumbers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

fun firstTimeInApplication(
    lifecycleScope: LifecycleCoroutineScope,
    activity: SingleActivity,
    dataStore: DataStoreManager,
    firebaseAuth: FirebaseAuth
) {
    lifecycleScope.launch {
        val firstTimeInApp = dataStore.readFirstTimeInApp.first()
        if (firstTimeInApp) {
            anonymousAuthentication(firebaseAuth = firebaseAuth, activity = activity)
            dataStore.saveDarkMode(MagicNumbers.DARK_MODE_AUTO)
            dataStore.saveTheme(MagicNumbers.DEFAULT_THEME)
            dataStore.saveFirstTimeInApp(false)
        }
    }
}
