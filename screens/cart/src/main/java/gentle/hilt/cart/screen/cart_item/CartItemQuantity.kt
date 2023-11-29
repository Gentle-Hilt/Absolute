package gentle.hilt.cart.screen.cart_item

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.themes.themeColors

@Composable
fun CartItemQuantity(
    quantity: String,
    modifier: Modifier
) {
    Text(text = quantity, modifier = modifier, color = MaterialTheme.themeColors.text)
}
