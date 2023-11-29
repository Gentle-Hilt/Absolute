package gentle.hilt.menu.screen.server_driven_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.res.reusable_ui_elements.ListType
import gentle.hilt.data.server_driven_ui.menu.MenuUiConfiguration

@Composable
fun extractListType(homeModes: MenuUiConfiguration?): ListType {
    return remember(homeModes?.listType, homeModes?.columnsInGrid) {
        when (homeModes?.listType) {
            "list" -> ListType.List
            "grid" -> ListType.Grid(homeModes.columnsInGrid)
            else -> ListType.List
        }
    }
}
