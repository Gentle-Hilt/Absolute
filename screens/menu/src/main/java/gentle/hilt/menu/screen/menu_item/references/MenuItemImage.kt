package gentle.hilt.menu.screen.menu_item.references

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import gentle.hilt.data.res.custom_composables.openBuilderAsyncImagePainter

@Composable
fun MenuItemImage(image: String?, modifier: Modifier) {
    Image(
        painter = openBuilderAsyncImagePainter(image = image, builder = { crossfade(true) }),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
    )
}
