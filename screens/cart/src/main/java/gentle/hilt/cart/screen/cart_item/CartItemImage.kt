package gentle.hilt.cart.screen.cart_item

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import gentle.hilt.data.res.custom_composables.openBuilderAsyncImagePainter

@Composable
fun CartItemImage(
    image:String,
    modifier: Modifier
){
    Image(
        painter = openBuilderAsyncImagePainter(image = image, builder = { crossfade(true) }),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}