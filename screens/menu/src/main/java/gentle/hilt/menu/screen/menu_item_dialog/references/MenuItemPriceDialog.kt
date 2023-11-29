package gentle.hilt.menu.screen.menu_item_dialog.references

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.themes.themeColors

@Composable
fun MenuItemPriceDialog(price: Long?, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .sizeIn(minHeight = 35.dp, minWidth = 40.dp)
            .background(MaterialTheme.themeColors.background, CircleShape)
            .padding(3.dp),
    ) {
        Text(
            color = MaterialTheme.themeColors.text,
            text = price.toString() + "$",
            fontSize = 20.sp,
            fontFamily = Fonts.sans_serif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}
