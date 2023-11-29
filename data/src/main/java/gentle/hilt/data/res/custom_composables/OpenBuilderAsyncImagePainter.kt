package gentle.hilt.data.res.custom_composables




import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest

@Composable
inline fun openBuilderAsyncImagePainter(
    image: Any?,
    builder: ImageRequest.Builder.() -> Unit
) = coil.compose.rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(image).apply(builder).build())