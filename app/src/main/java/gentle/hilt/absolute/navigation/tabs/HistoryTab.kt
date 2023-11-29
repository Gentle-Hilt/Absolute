package gentle.hilt.absolute.navigation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import gentle.hilt.data.res.strings.strings

object HistoryTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val history = strings.history
            return remember {
                TabOptions(
                    index = 0u,
                    title = history
                )
            }
        }

    @Composable
    override fun Content() {

    }
}
