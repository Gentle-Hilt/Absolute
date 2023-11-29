package gentle.hilt.categories.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import gentle.hilt.data.res.reusable_ui_elements.ListType
import gentle.hilt.data.server_driven_ui.categories.CategoriesUiConfiguration
import gentle.hilt.data.server_driven_ui.categories.Category
import gentle.hilt.server_driven_ui.SharedUiViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun Categories(
    categories: List<Category>,
    listType: ListType,
    modifier: Modifier,
) {

    Column(modifier) {
        CategoriesList(categories, listType)
    }

}


