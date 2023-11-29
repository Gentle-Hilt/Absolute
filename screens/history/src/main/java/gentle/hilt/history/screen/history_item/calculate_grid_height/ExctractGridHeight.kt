package gentle.hilt.history.screen.history_item.calculate_grid_height

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import gentle.hilt.data.datastore.MagicNumbers.BOUGHT_ITEM_SIZE
import gentle.hilt.data.datastore.MagicNumbers.HISTORY_GRID_CELLS
import gentle.hilt.data.datastore.MagicNumbers.HISTORY_LIST_CONTENT_PADDING

@Composable
fun calculateGridHeight(items: List<Any>): Dp {
    return remember(items) {
        val itemHeight = (BOUGHT_ITEM_SIZE + HISTORY_LIST_CONTENT_PADDING).dp
        val numColumns = HISTORY_GRID_CELLS
        val numRows = (items.size + numColumns - 1) / numColumns
        numRows * itemHeight
    }
}