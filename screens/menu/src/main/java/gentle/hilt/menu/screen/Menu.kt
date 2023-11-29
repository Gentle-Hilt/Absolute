package gentle.hilt.menu.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.reusable_ui_elements.ListType
import gentle.hilt.data.server_driven_ui.menu.MenuItem
import gentle.hilt.data.server_driven_ui.menu.MenuUiConfiguration

@Composable
fun Menu(
    list: List<MenuItem>,
    homeModes: MenuUiConfiguration,
    type: ListType,
    modifier: Modifier,
) {
    Column(modifier) {
        MenuList(list, type, homeModes)
    }
}




