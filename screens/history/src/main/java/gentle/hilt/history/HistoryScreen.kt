package gentle.hilt.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.history.screen.HistoryList
import org.koin.androidx.compose.getViewModel

class HistoryScreen : Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: HistoryScreenVM = getViewModel()
        val historyState = viewModel.historyState.collectAsStateWithLifecycle()

        ConstraintLayout(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.themeColors.background)
        ) {
            val (history) = createRefs()

            historyState.value?.history?.let { boughtItems ->
                HistoryList(
                    history = boughtItems,
                    modifier = Modifier.constrainAs(history) {
                        centerHorizontallyTo(parent)
                        centerVerticallyTo(parent)

                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    })
            }
        }
    }
}