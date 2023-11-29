package gentle.hilt.categories.screen.server_driven_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.server_driven_ui.UiEntity
import gentle.hilt.data.server_driven_ui.categories.CategoriesUiConfiguration

@Composable
fun extractUiConfiguration(uiState: UiEntity): CategoriesUiConfiguration {
    return remember(uiState.homeScreen.uiConfiguration) {
        uiState.homeScreen.uiConfiguration
    }
}

