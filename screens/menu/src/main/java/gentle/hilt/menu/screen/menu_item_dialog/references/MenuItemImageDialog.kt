package gentle.hilt.menu.screen.menu_item_dialog.references

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import gentle.hilt.data.res.custom_composables.openBuilderAsyncImagePainter
import gentle.hilt.data.res.strings.strings

@Composable
fun MenuItemImageDialog(image: String?, modifier: Modifier) {
    Image(
        painter = openBuilderAsyncImagePainter(image = image, builder = { crossfade(true) }),
        contentDescription = strings.content_description_item_from_menu,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}
