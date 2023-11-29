package gentle.hilt.cart.screen.logic

import androidx.compose.runtime.Composable
import gentle.hilt.data.cart.CartEntity

@Composable
fun SetPrice(cartState: CartEntity?): Long {
    return if (cartState?.price != null) {
        cartState.price
    } else {
        0L
    }
}
