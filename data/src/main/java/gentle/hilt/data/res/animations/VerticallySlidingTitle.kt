package gentle.hilt.data.res.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import gentle.hilt.data.datastore.MagicNumbers.TOP_BAR_TITLE_PADDING
import gentle.hilt.data.res.animations.content_transforms.contentTransformForSlidingTitle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun VerticallySlidingTitle(
    text: String,
) {
    AnimatedContent(
        modifier = Modifier.padding(top = TOP_BAR_TITLE_PADDING.dp),
        targetState = text,
        transitionSpec = {
            contentTransformForSlidingTitle()
        },
        label = "Sliding Tittle Animation",
        content = { animatedText ->
            Text(
                textAlign = TextAlign.Start,
                color = MaterialTheme.themeColors.text,
                text = animatedText,
            )
        }
    )

}