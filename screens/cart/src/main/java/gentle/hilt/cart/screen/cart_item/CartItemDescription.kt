package gentle.hilt.cart.screen.cart_item

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.themes.themeColors

@Composable
fun CartItemDescription(
    description: String,
    modifier: Modifier
){
    Text(
        color= MaterialTheme.themeColors.text,
        text = description,
        minLines = 2,
        maxLines = 4,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}