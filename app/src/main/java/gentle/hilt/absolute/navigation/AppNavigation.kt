package gentle.hilt.absolute.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.navigator.tab.AndroidTabDisposable
import cafe.adriel.voyager.navigator.tab.AndroidTabNavigator
import cafe.adriel.voyager.navigator.tab.CurrentAndroidTab
import gentle.hilt.absolute.navigation.tabs.CartTab
import gentle.hilt.absolute.navigation.tabs.CategoriesTab
import gentle.hilt.absolute.navigation.tabs.HistoryTab
import gentle.hilt.absolute.navigation.tabs.ProfileTab
import gentle.hilt.absolute.navigation.tabs.TabNavigationItem
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.datastore.MagicNumbers.BOTTOM_NAVIGATION_HEIGHT
import gentle.hilt.data.datastore.MagicNumbers.SEARCH_ICON_SIZE

import gentle.hilt.data.res.themes.NoRippleEffectTheme
import gentle.hilt.data.res.themes.themeColors

@Composable
fun AppNavigation(dataStore: DataStoreManager) {
    // I added tabs to backstack history
    // for backstack logs to be in a format [Home, Profile, Home, Category, Profile]
    val tabTitlesToTabs = mutableMapOf(
        CategoriesTab.options.title to CategoriesTab,
        ProfileTab.options.title to ProfileTab,
        CartTab.options.title to CartTab,
        HistoryTab.options.title to HistoryTab
    )
    AndroidTabNavigator(
        initialTab = CategoriesTab,
        titlesToTabs = tabTitlesToTabs,
        noBackStackGoToThePreviousTab = true,
        tabDisposable = { androidTabNavigator ->
            AndroidTabDisposable(
                tabNavigator = androidTabNavigator,
                tabs = listOf(CategoriesTab, HistoryTab, CartTab, ProfileTab)
            )
        }
    ) { tabNavigator ->
        Scaffold(
            topBar = {
                val currentTabTitle = tabNavigator.current.options.title
                val currentTopBarTitle by dataStore.readCurrentTopBarTitle.collectAsStateWithLifecycle(initialValue = "")
                val tabHistory by tabNavigator.tabHistory.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = tabHistory, block = { dataStore.saveCurrentTopBarTitle(currentTabTitle) })

                TopAppBar(
                    title = {  },
                    backgroundColor = MaterialTheme.themeColors.background
                )
            },
            content = { padding ->
                Box(Modifier.padding(padding)) {
                    CurrentAndroidTab()
                }
            },
            bottomBar = {
                //  Still has ripple effect on android 13+ (emulator) 
                CompositionLocalProvider(LocalRippleTheme provides NoRippleEffectTheme) {
                    Surface(
                        modifier = Modifier,
                        color = MaterialTheme.themeColors.fadeIcons,
                        elevation = BottomNavigationDefaults.Elevation
                    ) {
                        BottomNavigation(
                            modifier = Modifier.height(BOTTOM_NAVIGATION_HEIGHT.dp),
                            backgroundColor = MaterialTheme.themeColors.bottomNavigation
                        ) {
                            TabNavigationItem(CategoriesTab, HomeIconPainter())
                            TabNavigationItem(HistoryTab, SearchIconPainter(), iconSize = SEARCH_ICON_SIZE.dp)
                            TabNavigationItem(CartTab, CartIconPainter())
                            TabNavigationItem(ProfileTab, ProfileIconPainter())
                        }
                    }
                }
            }
        )
    }
}
