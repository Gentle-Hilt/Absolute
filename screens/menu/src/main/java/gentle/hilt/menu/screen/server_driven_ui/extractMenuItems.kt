package gentle.hilt.menu.screen.server_driven_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.server_driven_ui.UiEntity
import gentle.hilt.data.server_driven_ui.categories.Category
import gentle.hilt.data.server_driven_ui.menu.MenuItem


@Composable
fun extractMenuItems(uiState: UiEntity, category: Category): List<MenuItem?> {
    return remember(uiState.homeScreen.categoriesList.data) {
        uiState.homeScreen.categoriesList.data.flatMap { newCategory ->
            val listOfMenuItemsOld = category.products
            val listOfMenuItemsNew = newCategory.products
            if (newCategory == category) {
                category.products
            } else {
                listOfMenuItemsOld.map { oldItem ->
                    val newItem = listOfMenuItemsNew.firstOrNull { it.id == oldItem.id }
                    newItem
                }
            }
        }.distinct()
    }
}

/*
@Composable
fun ExtractMenuItems2(uiState: UiEntity, category: Category): List<MenuItem2?> {
    return remember(uiState.homeScreen.categoriesList.data) {
        uiState.homeScreen.categoriesList.data.flatMap { newCategory ->
            val listOfMenuItemsOld = category.products2
            val listOfMenuItemsNew = newCategory.products2
            if (newCategory == category) {
                category.products2
            } else {
                listOfMenuItemsOld.map { oldItem ->
                    val newItem = listOfMenuItemsNew.firstOrNull { it.id == oldItem.id }
                    newItem
                }
            }
        }.distinct()
    }
}*/
