package gentle.hilt.cart.screen.cart_item

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.themes.themeColors

@Composable
fun CartItemTitle(
    title:String,
    modifier: Modifier
) {
    Text(
        color = MaterialTheme.themeColors.text,
        textAlign = TextAlign.Center,
        minLines = 2,
        maxLines = 2,
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = modifier
    )
}