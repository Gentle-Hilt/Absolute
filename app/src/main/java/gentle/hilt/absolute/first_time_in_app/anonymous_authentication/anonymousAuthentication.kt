package gentle.hilt.absolute.first_time_in_app.anonymous_authentication

import com.google.firebase.auth.FirebaseAuth
import gentle.hilt.absolute.SingleActivity

fun anonymousAuthentication(firebaseAuth: FirebaseAuth, activity: SingleActivity) {
    if (firebaseAuth.currentUser == null) {
        firebaseAuth.signInAnonymously().addOnCompleteListener(activity) {}
    }
}
