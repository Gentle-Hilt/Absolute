package gentle.hilt.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.cart.screen.ClearCartButton
import gentle.hilt.cart.screen.PayCartButton
import gentle.hilt.cart.screen.cart_list.CartList
import gentle.hilt.cart.screen.logic.SetPrice
import gentle.hilt.data.cart.CartEntity
import gentle.hilt.data.res.themes.themeColors
import org.koin.androidx.compose.getViewModel

class CartScreen : Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: CartScreenVM = getViewModel()
        val cartState = viewModel.cartState.collectAsStateWithLifecycle()

        ConstraintLayout(
            Modifier.fillMaxSize().background(MaterialTheme.themeColors.background)
        ) {
            val (menuItemsRef, confirmRef, clearRef) = createRefs()

            cartState.value?.groupedList?.let { menuList ->
                CartList(
                    cartList = menuList,
                    Modifier.constrainAs(menuItemsRef) {
                        top.linkTo(parent.top)
                        centerHorizontallyTo(parent)
                        bottom.linkTo(confirmRef.top)

                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    })
            }

            ClearCartButton(
                modifier = Modifier.constrainAs(clearRef) {
                    bottom.linkTo(confirmRef.bottom)
                    top.linkTo(confirmRef.top)
                    start.linkTo(parent.start)
                    end.linkTo(confirmRef.start)

                    width = Dimension.percent(0.3f)
                })

            PayCartButton(
                price = SetPrice(cartState.value),
                modifier = Modifier.constrainAs(confirmRef) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(clearRef.end)
                    width = Dimension.percent(0.6f)
                })
        }

    }
}



