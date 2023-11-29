package gentle.hilt.history.screen.history_item.references

import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import gentle.hilt.data.cart.GroupedMenuItem
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.history.HistoryScreenVM

@Composable
fun HistoryItemButtonReorder(
    history: List<GroupedMenuItem>,
    viewModel: HistoryScreenVM,
    modifier:Modifier
)   {
    val addedToTheCart = strings.added_to_the_cart
    val context = LocalContext.current
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(MaterialTheme.themeColors.icons),
        onClick = {
            Toast.makeText(context, addedToTheCart, Toast.LENGTH_SHORT).show()
            viewModel.reorder(history)
        }
    ) {
        Text(text = strings.reorder, color = MaterialTheme.themeColors.contrastText)
    }
}