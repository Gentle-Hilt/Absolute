package gentle.hilt.categories.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.categories.screen.category_item.CategoryItem
import gentle.hilt.data.res.reusable_ui_elements.ListType
import gentle.hilt.data.server_driven_ui.categories.Category

@Composable
fun CategoriesList(
    categories: List<Category>,
    type: ListType
) {
    when (type) {
        is ListType.List -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),

                content = {
                    items(categories.size) { index ->
                        CategoryItem(categories[index], type)
                    }
                },
                contentPadding = PaddingValues(5.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            )
        }

        is ListType.Grid -> {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(type.columns),

                content = {
                    items(categories.size) { index ->
                        CategoryItem(categories[index], type)
                    }
                },
                contentPadding = PaddingValues(5.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            )
        }
    }
}
