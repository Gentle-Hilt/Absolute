package gentle.hilt.absolute.navigation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import gentle.hilt.cart.CartScreen
import gentle.hilt.data.res.strings.strings

object CartTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val cart = strings.cart
            return remember {
                TabOptions(
                    index = 0u,
                    title = cart
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent(CartScreen())
    }
}
