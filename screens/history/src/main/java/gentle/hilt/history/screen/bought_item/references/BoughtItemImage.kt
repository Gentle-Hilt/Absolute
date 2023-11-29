package gentle.hilt.history.screen.bought_item.references

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import gentle.hilt.data.res.custom_composables.openBuilderAsyncImagePainter

@Composable
fun BoughtItemImage(image: String, modifier: Modifier){
    Image(
        painter = openBuilderAsyncImagePainter(image = image) { crossfade(true) },
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}
