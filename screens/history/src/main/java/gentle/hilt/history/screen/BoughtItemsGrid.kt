package gentle.hilt.history.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.cart.GroupedMenuItem
import gentle.hilt.data.datastore.MagicNumbers.HISTORY_GRID_CELLS
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.history.screen.bought_item.BoughtItem

@Composable
fun BoughtItemsGrid(
    boughtItems: List<GroupedMenuItem>,
    modifier: Modifier
) {

    LazyVerticalGrid(
        userScrollEnabled = false,
        columns = GridCells.Fixed(HISTORY_GRID_CELLS),
        modifier = modifier.background(MaterialTheme.themeColors.background),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(boughtItems.size) { index ->
                BoughtItem(boughtItems[index])
            }
        })
}

