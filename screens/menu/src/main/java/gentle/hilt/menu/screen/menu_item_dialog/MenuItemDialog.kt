package gentle.hilt.menu.screen.menu_item_dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.menu.screen.menu_item_dialog.references.ConfirmButtonDialog
import gentle.hilt.menu.screen.menu_item_dialog.references.DescriptionDialog
import gentle.hilt.menu.screen.menu_item_dialog.references.DismissButtonDialog
import gentle.hilt.menu.screen.menu_item_dialog.references.MenuItemImageDialog
import gentle.hilt.menu.screen.menu_item_dialog.references.MenuItemPriceDialog

@Composable
fun MenuItemDialog(
    image: String?,
    price: Long?,
    description: String?,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .background(MaterialTheme.themeColors.background)
        ) {
            val (imageRef, descriptionRef, confirmRef, dismissRef, priceRef) = createRefs()

            MenuItemImageDialog(
                image = image,
                modifier = Modifier.constrainAs(imageRef) {
                    top.linkTo(parent.top)
                    centerHorizontallyTo(parent)
                    bottom.linkTo(descriptionRef.top)

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                })

            DescriptionDialog(
                description = description,
                modifier = Modifier.constrainAs(descriptionRef) {
                    top.linkTo(imageRef.bottom)
                    centerHorizontallyTo(parent)
                    bottom.linkTo(confirmRef.top)
                })


            ConfirmButtonDialog(
                onConfirm = {
                    onConfirm()
                },
                modifier = Modifier.constrainAs(confirmRef) {
                    centerHorizontallyTo(parent)
                    bottom.linkTo(parent.bottom)

                    width = Dimension.fillToConstraints
                })


            DismissButtonDialog(
                onDismiss = { onDismiss() },
                modifier = Modifier.constrainAs(dismissRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                })

            MenuItemPriceDialog(
                price = price,
                modifier = Modifier.constrainAs(priceRef) {
                end.linkTo(imageRef.end, margin = 2.dp)
                bottom.linkTo(imageRef.bottom, margin = 2.dp)
            })
        }
    }
}










