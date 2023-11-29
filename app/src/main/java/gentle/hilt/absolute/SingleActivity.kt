package gentle.hilt.absolute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import gentle.hilt.absolute.navigation.AppNavigation
import gentle.hilt.absolute.theme_selector.ProvideThemes
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.strings.LocalStrings
import gentle.hilt.data.res.strings.allLocales
import gentle.hilt.server_driven_ui.SharedUiViewModel
import org.koin.android.ext.android.inject

class SingleActivity : ComponentActivity() {

    val viewModel: SharedUiViewModel by inject()
    private val dataStore: DataStoreManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycleObserver())

        setContent {
            ProvideThemes(dataStore) {
                ProvideStrings(lyricist = rememberStrings(allLocales), provider = LocalStrings) {
                    AppNavigation(dataStore = dataStore)
                }
            }
        }
    }

    private inner class AppLifecycleObserver : LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            when (event) {
                Lifecycle.Event.ON_START -> {
                    viewModel.observeUpdatesFromRTDB(source.lifecycleScope)
                }

                else -> Unit
            }
        }
    }
}