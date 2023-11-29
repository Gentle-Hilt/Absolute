package gentle.hilt.data.res.custom_composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import gentle.hilt.data.datastore.DataStoreManager
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
inline fun <reified T> ListWithAnyType(
    dialogActions: List<Pair<T, String>>,
    crossinline content: @Composable (T, String) -> Unit,
) {

    LazyColumn(
        horizontalAlignment = Alignment.Start,
        content = {
            items(dialogActions) { (action, text) ->
                content(action, text)
            }
        })
}


@Composable
fun <T> AnyItem(action: T, name: String, dataStore: DataStoreManager) {
    val coroutineScope = rememberCoroutineScope()
    Text(text = name, Modifier.clickable {

        when (action) {
            is Function0<*> -> (action as Function0<*>).invoke()
            is Job -> (action as Job).start()
            is Int -> coroutineScope.launch { dataStore.saveTheme(action) }
        }

    })
}

