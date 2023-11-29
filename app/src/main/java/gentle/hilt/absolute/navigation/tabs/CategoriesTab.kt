package gentle.hilt.absolute.navigation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import gentle.hilt.categories.CategoriesScreen
import gentle.hilt.data.res.strings.strings

object CategoriesTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val home = strings.home
            return remember {

                TabOptions(
                    index = 0u,
                    title = home
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent(CategoriesScreen())
    }
}
