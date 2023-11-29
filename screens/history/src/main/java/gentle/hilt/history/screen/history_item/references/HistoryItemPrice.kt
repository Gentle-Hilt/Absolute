package gentle.hilt.history.screen.history_item.references

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.themes.themeColors


@Composable
fun HistoryItemPrice(
    text:String,
    modifier: Modifier
) {
    Text(
        color = MaterialTheme.themeColors.text,
        textAlign = TextAlign.Center,
        minLines = 1,
        maxLines = 2,
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        modifier = modifier
    )
}