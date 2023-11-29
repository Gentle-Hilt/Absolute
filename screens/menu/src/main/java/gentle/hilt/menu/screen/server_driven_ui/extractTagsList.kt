package gentle.hilt.menu.screen.server_driven_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.server_driven_ui.menu.MenuItem

@Composable
fun extractTagsList(menuItems: List<MenuItem?>): List<String> {
    return remember(menuItems) {
        menuItems.flatMap { menuItem ->
            menuItem?.tag?.split(",")?.distinct() ?: emptyList()
        }
    }
}