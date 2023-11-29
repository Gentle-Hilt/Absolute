package gentle.hilt.menu.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.datastore.MagicNumbers.MENU_CONTENT_PADDING
import gentle.hilt.data.res.reusable_ui_elements.ListType
import gentle.hilt.data.server_driven_ui.menu.MenuItem
import gentle.hilt.data.server_driven_ui.menu.MenuUiConfiguration
import gentle.hilt.menu.screen.menu_item.MenuItem

@Composable
fun MenuList(
    menuList: List<MenuItem>,
    type: ListType,
    homeModes: MenuUiConfiguration,
) {
    when (type) {
        is ListType.List -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),

                content = {
                    items(menuList.size) { index ->
                        MenuItem(menuList[index], type, homeModes)
                    }
                },
                verticalArrangement = Arrangement.spacedBy(MENU_CONTENT_PADDING.dp)
            )
        }

        is ListType.Grid -> {
            LazyVerticalGrid(

                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(type.columns),

                content = {
                    items(menuList.size) { index ->
                        MenuItem(menuList[index], type, homeModes)
                    }
                },

                contentPadding = PaddingValues(all = MENU_CONTENT_PADDING.dp),
                horizontalArrangement = Arrangement.spacedBy(MENU_CONTENT_PADDING.dp),
                verticalArrangement = Arrangement.spacedBy(MENU_CONTENT_PADDING.dp)
            )
        }
    }
}