package gentle.hilt.absolute.navigation.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import gentle.hilt.absolute.navigation.transition_animation.CustomSlidingTransition

@Composable
fun Tab.TabContent(screen: Screen) {
    /*  val tabTitle = options.title*/
    // Todo add it later
/*    LifecycleEffect(
        onStarted = { Timber.d("Start tab $tabTitle") },
        onDisposed = { Timber.d("Dispose tab $tabTitle") }
    )*/

    Navigator(screen) { navigator ->
        CustomSlidingTransition(navigator)
    }
}
