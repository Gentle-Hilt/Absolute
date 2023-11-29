package gentle.hilt.data.res.custom_composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog

@Composable
inline fun <reified T> DialogWithAnyTypeOfData(
    crossinline uiContainer: @Composable (content: @Composable () -> Unit) -> Unit = { it()},
    crossinline onDismissRequest: () -> Unit,
    crossinline item: @Composable (T, String, () -> Unit) -> Unit,
    dialogActionsInOrder: List<Pair<T, String>>,
) {
    Dialog(
        onDismissRequest = { onDismissRequest() },
    ) {
        uiContainer {
            ListWithAnyType(
                dialogActions = dialogActionsInOrder,
            ) { action, text ->
                item(action, text) { onDismissRequest() }
            }
        }
    }
}