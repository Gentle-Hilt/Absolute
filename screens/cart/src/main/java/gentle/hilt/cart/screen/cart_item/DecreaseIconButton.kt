package gentle.hilt.cart.screen.cart_item

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.themes.themeColors

@Composable
fun DecreaseIconButton(
    modifier: Modifier,
    decrease: () -> Unit
){
    IconButton(
        modifier = modifier,
        onClick = { decrease() }
    ) {
        Icon(
            tint = MaterialTheme.themeColors.text,
            imageVector = Icons.Default.Remove,
            contentDescription = "Decrease amount of product in cart"
        )
    }
}