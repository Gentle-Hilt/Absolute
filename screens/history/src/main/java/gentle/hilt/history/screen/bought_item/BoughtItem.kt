package gentle.hilt.history.screen.bought_item

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import gentle.hilt.data.cart.GroupedMenuItem
import gentle.hilt.data.datastore.MagicNumbers.BOUGHT_ITEM_SIZE
import gentle.hilt.data.res.themes.themeColors

import gentle.hilt.history.screen.bought_item.references.BoughtItemImage
import gentle.hilt.history.screen.bought_item.references.BoughtItemQuantity


@Composable
fun BoughtItem(boughtItem: GroupedMenuItem){

    ConstraintLayout(
        modifier = Modifier.size(BOUGHT_ITEM_SIZE.dp)
            .clip(RoundedCornerShape(20))
            .border(
                1.dp,
                color = MaterialTheme.themeColors.text,
                shape = RoundedCornerShape(20)
            )

    ) {
        val (image, quantity) = createRefs()

        BoughtItemImage(
            boughtItem.image,
            modifier = Modifier.constrainAs(image){
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)

            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        })


        BoughtItemQuantity(
            boughtItem.quantity,
            modifier = Modifier.constrainAs(quantity){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        })

    }
}