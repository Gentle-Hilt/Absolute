package gentle.hilt.categories.screen.category_item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import gentle.hilt.categories.screen.category_item.references.CategoryImage
import gentle.hilt.categories.screen.category_item.references.CategoryTitle
import gentle.hilt.data.res.reusable_ui_elements.ListType
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.server_driven_ui.categories.Category
import gentle.hilt.navigation.SharedScreen

@Composable
fun CategoryItem(
    category: Category,
    type: ListType,
    navigator: Navigator = LocalNavigator.currentOrThrow,
) {
    val menuScreen = ScreenRegistry.get(SharedScreen.MenuScreen(category))

    val size = when (type) {
        is ListType.List -> { Modifier.height(250.dp).fillMaxWidth() }
        is ListType.Grid -> { Modifier.size(150.dp, 200.dp) }
    }

    ConstraintLayout(
        modifier = size
            .shadow(8.dp, shape = RoundedCornerShape(10.dp), clip = true)
            .clip(RoundedCornerShape(10.dp))
            .background(color = MaterialTheme.themeColors.bottomNavigation)
            .clickable { navigator.push(menuScreen) }
    ) {
        val (categoryImage, categoryTitle) = createRefs()

        CategoryImage(
            image = category.image,
            modifier = Modifier.constrainAs(categoryImage) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)

            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        })

        CategoryTitle(
            title = category.title,
            modifier = Modifier.constrainAs(categoryTitle) {
            centerHorizontallyTo(parent)
            bottom.linkTo(parent.bottom)

            width = Dimension.fillToConstraints
        })
    }
}




