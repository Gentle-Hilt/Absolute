package gentle.hilt.categories.screen.server_driven_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.res.reusable_ui_elements.ListType
import gentle.hilt.data.server_driven_ui.UiEntity
import gentle.hilt.data.server_driven_ui.categories.CategoriesUiConfiguration

@Composable
fun extractListType(
    uiEntity: UiEntity?,
    uiConfiguration: CategoriesUiConfiguration? = uiEntity?.homeScreen?.uiConfiguration
): ListType {
    return remember(uiConfiguration?.listType, uiConfiguration?.columnsInGrid) {
        when (uiConfiguration?.listType) {
            "list" -> ListType.List
            "grid" -> ListType.Grid(uiConfiguration.columnsInGrid)
            else -> ListType.List
        }
    }
}
