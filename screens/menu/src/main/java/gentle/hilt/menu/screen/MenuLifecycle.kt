package gentle.hilt.menu.screen

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.server_driven_ui.categories.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber


@Composable
fun MenuScreenLifeCycle(
    Screen: Screen,
    category: Category,
    dataStore: DataStoreManager,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navigator: Navigator = LocalNavigator.currentOrThrow,
) {
    val home = strings.home

    Screen.LifecycleEffect(
        onStarted = { Timber.d("Start menu screen") },
        onDisposed = { Timber.d("Dispose menu screen") }
    )

    LaunchedEffect(category.title) {
        // "Firebase Cloud Functions" is not Free!, so no translation for our categories
        dataStore.saveCurrentTopBarTitle(category.title ?: "")
    }


    BackHandler {
        coroutineScope.launch {
            dataStore.saveCurrentTopBarTitle(home)
            if (navigator.canPop) {
                navigator.pop()
            }
        }
    }
}