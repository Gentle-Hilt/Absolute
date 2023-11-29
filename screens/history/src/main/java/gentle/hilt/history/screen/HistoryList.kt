package gentle.hilt.history.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.datastore.MagicNumbers.HISTORY_LIST_CONTENT_PADDING
import gentle.hilt.data.history.BoughtItem
import gentle.hilt.data.res.custom_composables.scrollToLastItemInList
import gentle.hilt.history.screen.history_item.HistoryItem

@Composable
fun HistoryList(
    history: List<BoughtItem>,
    modifier: Modifier,
) {
    Column(modifier) {
        LazyColumn(
            state = scrollToLastItemInList(list = history),
            reverseLayout = true,
            modifier = Modifier.fillMaxSize(),
            content = {
                items(history.size) { index ->
                    HistoryItem(history = history[index])
                }
            },

            contentPadding = PaddingValues(HISTORY_LIST_CONTENT_PADDING.dp),
            verticalArrangement = Arrangement.spacedBy(HISTORY_LIST_CONTENT_PADDING.dp)
        )
    }
}
