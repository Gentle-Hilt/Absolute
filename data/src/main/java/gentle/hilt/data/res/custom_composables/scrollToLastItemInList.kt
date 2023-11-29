package gentle.hilt.data.res.custom_composables

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect


@Composable
fun scrollToLastItemInList(list: List<Any>): LazyListState {
    val lazyListState = rememberLazyListState()

    LaunchedEffect(list) {
        lazyListState.scrollToItem(list.size - 1)
    }

    return lazyListState

}
