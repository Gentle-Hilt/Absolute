package gentle.hilt.data.di

import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

//  AuthUI.IdpConfig.EmailBuilder().build() has issue https://github.com/firebase/firebaseui-web/issues/1040
val authModule = module {
    single { AuthUI.getInstance() }
    single { FirebaseAuth.getInstance() }
}