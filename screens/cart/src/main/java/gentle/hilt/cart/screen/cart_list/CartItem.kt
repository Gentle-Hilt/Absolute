package gentle.hilt.cart.screen.cart_list

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import gentle.hilt.cart.screen.cart_item.CartItemDescription
import gentle.hilt.cart.screen.cart_item.CartItemImage
import gentle.hilt.cart.screen.cart_item.CartItemPrice
import gentle.hilt.cart.screen.cart_item.CartItemQuantity
import gentle.hilt.cart.screen.cart_item.CartItemTitle
import gentle.hilt.cart.screen.cart_item.DecreaseIconButton
import gentle.hilt.cart.screen.cart_item.IncreaseIconButton
import gentle.hilt.data.cart.GroupedMenuItem
import gentle.hilt.data.res.themes.themeColors


@Composable
fun CartItem(
    menuItem: GroupedMenuItem,
    increase: () -> Unit,
    decrease: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth().height(150.dp).border(1.dp, color = MaterialTheme.themeColors.text)
    ) {
        val (image, price, title, description, amountRef, increaseRef, decreaseRef) = createRefs()

        CartItemTitle(
            title = menuItem.title,

            Modifier.constrainAs(title) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                start.linkTo(image.end)

                width = Dimension.fillToConstraints
            })

        CartItemImage(
            image = menuItem.image,
            Modifier.constrainAs(image) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)

                width = Dimension.percent(0.40f)
                height = Dimension.fillToConstraints
            })

        CartItemDescription(
            description = menuItem.description,
            Modifier.constrainAs(description) {
                bottom.linkTo(parent.bottom)
                start.linkTo(image.end)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
            })

        CartItemPrice(
            price = "price: ${menuItem.quantity * menuItem.price}$",
            Modifier.constrainAs(price) {
                top.linkTo(decreaseRef.top)
                end.linkTo(decreaseRef.start)
                bottom.linkTo(decreaseRef.bottom)
            })

        DecreaseIconButton(
            Modifier.constrainAs(decreaseRef) {
                top.linkTo(amountRef.top)
                end.linkTo(amountRef.start)
                bottom.linkTo(amountRef.bottom)
            }) {
            decrease()
        }

        CartItemQuantity(
            quantity = menuItem.quantity.toString(),
            Modifier.constrainAs(amountRef) {
                top.linkTo(title.bottom)
                start.linkTo(image.end, margin = 50.dp)
                end.linkTo(parent.end)
                bottom.linkTo(description.top, margin = 10.dp)
            })

        IncreaseIconButton(
            Modifier.constrainAs(increaseRef) {
                top.linkTo(amountRef.top)
                start.linkTo(amountRef.end)
                bottom.linkTo(amountRef.bottom)
            }) {
            increase()
        }

    }
}