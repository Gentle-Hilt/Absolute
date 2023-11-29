package gentle.hilt.cart.screen.cart_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.cart.CartScreenVM
import gentle.hilt.data.cart.GroupedMenuItem
import gentle.hilt.data.res.custom_composables.scrollToLastItemInList
import gentle.hilt.data.res.themes.themeColors
import org.koin.androidx.compose.getViewModel


@Composable
fun CartList(
    cartList: MutableList<GroupedMenuItem>,
    modifier: Modifier,
    viewModel: CartScreenVM = getViewModel()
) {

    Column(modifier) {
        LazyColumn(
            state = scrollToLastItemInList(list = cartList),
            reverseLayout = true,
            modifier = modifier.background(MaterialTheme.themeColors.background),
            content = {
                items(cartList) { group ->
                    CartItem(
                        group,
                        increase = { viewModel.updateQuantity(group.id, shouldIncrease = true) },
                        decrease = { viewModel.updateQuantity(group.id, shouldIncrease = false) }
                    )
                }
            },

            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        )
    }
}
