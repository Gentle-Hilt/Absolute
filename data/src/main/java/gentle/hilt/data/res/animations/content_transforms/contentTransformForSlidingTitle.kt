package gentle.hilt.data.res.animations.content_transforms

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith

fun contentTransformForSlidingTitle(): ContentTransform {
    val enterTransition = slideInVertically { offSet -> offSet } + fadeIn()
    val exitTransition = slideOutVertically { offSet -> -offSet } + fadeOut()

    return enterTransition togetherWith exitTransition
}