package gentle.hilt.menu.screen.menu_item.references

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.themes.themeColors

@Composable
fun MenuItemTitle(title: String?, modifier: Modifier) {
    Text(
        text = title ?: "",
        color = MaterialTheme.themeColors.text,
        fontSize = 16.sp,
        fontFamily = Fonts.sans_serif,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center,
        minLines = 2,
        maxLines = 2,
        modifier = modifier
    )
}
