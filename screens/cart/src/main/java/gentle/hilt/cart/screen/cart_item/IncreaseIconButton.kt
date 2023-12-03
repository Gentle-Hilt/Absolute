package gentle.hilt.cart.screen.cart_item

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.drawables.AddIcon
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
            modifier = Modifier.size(15.dp),
            tint = MaterialTheme.themeColors.text,
            painter = AddIcon(),
            contentDescription = "Increase amount of product in cart"
        )
    }
}