package gentle.hilt.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import gentle.hilt.categories.screen.Categories
import gentle.hilt.categories.screen.server_driven_ui.extractCategories
import gentle.hilt.categories.screen.server_driven_ui.extractListType
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.server_driven_ui.SharedUiViewModel
import org.koin.androidx.compose.getViewModel

class CategoriesScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: SharedUiViewModel = getViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.themeColors.background)
        ) {
            val (category) = createRefs()

            uiState?.let { uiEntity ->
                val listType = extractListType(uiEntity)
                val categories = extractCategories(uiEntity)

                Categories(
                    categories,
                    listType,
                    modifier = Modifier.constrainAs(category) {
                        centerHorizontallyTo(parent)
                        centerVerticallyTo(parent)
                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    }
                )
            }
        }
    }
}