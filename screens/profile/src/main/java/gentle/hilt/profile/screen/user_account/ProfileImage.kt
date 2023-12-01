package gentle.hilt.profile.screen.user_account

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import gentle.hilt.data.datastore.MagicNumbers
import gentle.hilt.data.res.custom_composables.openBuilderAsyncImagePainter

@Composable
fun ProfileImage(image: Uri?, modifier: Modifier){
    Image(
        painter = openBuilderAsyncImagePainter(image =
        image?.toString() ?: MagicNumbers.defaultUserProfileImage,
            builder = { crossfade(true) }),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(RoundedCornerShape(10))
    )
}


