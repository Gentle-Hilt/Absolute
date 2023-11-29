package gentle.hilt.cart.screen.cart_item

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.themes.themeColors

@Composable
fun CartItemPrice(
    price: String,
    modifier: Modifier
) {
    Text(
        color = MaterialTheme.themeColors.text,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        text = price,
        modifier = modifier
    )
}