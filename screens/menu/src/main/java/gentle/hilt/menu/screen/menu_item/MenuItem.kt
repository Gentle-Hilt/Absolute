package gentle.hilt.menu.screen.menu_item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import gentle.hilt.data.res.reusable_ui_elements.ListType
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.server_driven_ui.menu.MenuItem
import gentle.hilt.data.server_driven_ui.menu.MenuUiConfiguration
import gentle.hilt.menu.MenuScreenVM
import gentle.hilt.menu.screen.menu_item.references.MenuItemImage
import gentle.hilt.menu.screen.menu_item.references.MenuItemPrice
import gentle.hilt.menu.screen.menu_item.references.MenuItemTitle
import gentle.hilt.menu.screen.menu_item_dialog.MenuItemDialog
import org.koin.androidx.compose.getViewModel

@Composable
fun MenuItem(
    menuItem: MenuItem,
    type: ListType,
    homeModes: MenuUiConfiguration,
    viewModel: MenuScreenVM = getViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }

    val size = when (type) {
        is ListType.List -> { Modifier.height(homeModes.itemHeight.dp).fillMaxWidth() }
        is ListType.Grid -> { Modifier.height(homeModes.itemHeight.dp) }
    }

    ConstraintLayout(
        modifier = size
            .shadow(12.dp, shape = RoundedCornerShape(16.dp), clip = true)
            .clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
            .background(color = MaterialTheme.themeColors.background)
            .clickable { showDialog = true }
    ) {
        val (image, title, price) = createRefs()

        MenuItemImage(
            image = menuItem.image,
            modifier = Modifier.constrainAs(image) {
            top.linkTo(parent.top)
            bottom.linkTo(title.top)
            centerHorizontallyTo(parent)

            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        })

        MenuItemTitle(
            title = menuItem.title,
            modifier = Modifier.constrainAs(title) {
            bottom.linkTo(parent.bottom)
            centerHorizontallyTo(parent)

            width = Dimension.fillToConstraints
        })

        MenuItemPrice(
            price = menuItem.price,
            modifier = Modifier.constrainAs(price) {
            top.linkTo(parent.top, margin = 2.dp)
            end.linkTo(parent.end, margin = 2.dp)
        })
    }


    if (showDialog) {
        MenuItemDialog(
            image = menuItem.image,
            price = menuItem.price,
            description = menuItem.description,
            onDismiss = { showDialog = false },
            onConfirm = { viewModel.addMenuItemToCart(menuItem) }
        )
    }
}





