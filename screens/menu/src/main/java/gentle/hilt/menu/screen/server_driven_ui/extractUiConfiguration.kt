package gentle.hilt.menu.screen.server_driven_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.server_driven_ui.UiEntity
import gentle.hilt.data.server_driven_ui.menu.MenuUiConfiguration

@Composable
fun extractUiConfiguration(uiState: UiEntity): MenuUiConfiguration {
    return remember(uiState.cartScreen.uiConfiguration) {
        uiState.cartScreen.uiConfiguration
    }
}

