package gentle.hilt.categories.screen.server_driven_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.server_driven_ui.UiEntity
import gentle.hilt.data.server_driven_ui.categories.Category

@Composable
fun extractCategories(uiState: UiEntity): List<Category> {
    return remember(uiState) {
        uiState.homeScreen.categoriesList.data
    }
}