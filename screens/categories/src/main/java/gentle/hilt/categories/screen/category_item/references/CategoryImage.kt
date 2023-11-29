package gentle.hilt.categories.screen.category_item.references

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter


@Composable
fun CategoryImage(image: String?, modifier: Modifier) {
    Image(
        painter = rememberAsyncImagePainter(model = image),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}
