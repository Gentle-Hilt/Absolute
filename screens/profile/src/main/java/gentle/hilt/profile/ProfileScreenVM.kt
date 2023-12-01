package gentle.hilt.profile

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileScreenVM(
    private val authUi: AuthUI,
) : ViewModel() {


    fun auth(): Intent {
        return authUi
            .createSignInIntentBuilder()
            .setAvailableProviders(
                listOf(
                    AuthUI.IdpConfig.GoogleBuilder().build(),
                )
            )
            .build()
    }


    private val _userState = MutableStateFlow(FirebaseAuth.getInstance().currentUser)
    val userState: StateFlow<FirebaseUser?> = _userState

    fun updateCurrentUserState() {
        _userState.value = FirebaseAuth.getInstance().currentUser
    }

    fun logOut() {
        FirebaseAuth.getInstance().signOut()
        _userState.value = null
    }

}