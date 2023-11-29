package gentle.hilt.cart.screen.cart_item

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.themes.themeColors

@Composable
fun IncreaseIconButton(
    modifier: Modifier,
    increase: () -> Unit
){
    IconButton(
        modifier = modifier,
        onClick = { increase() }
    ) {
        Icon(
            tint = MaterialTheme.themeColors.text,
            imageVector = Icons.Default.Add,
            contentDescription = "Increase amount of product in cart"
        )
    }
}