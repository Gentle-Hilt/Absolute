package gentle.hilt.menu.screen.server_driven_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.server_driven_ui.menu.MenuItem

@Composable
fun extractFilteredMenuItems(selectedTags: List<String>, menuItems: List<MenuItem?>): List<MenuItem> {
    return remember(selectedTags, menuItems) {
        menuItems.filterNotNull().filter { menuItem ->
            selectedTags.isEmpty() || menuItem.tag?.split(",")?.any { it in selectedTags } == true
        }
    }
}