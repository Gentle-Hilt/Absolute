package gentle.hilt.data.res.animations.content_transforms

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith

fun contentTransformForTransitionAnimationOut() : ContentTransform {
    val enterTransition = slideInHorizontally { it }
    val exitTransition =  slideOutHorizontally { -it / 2 }

    return enterTransition togetherWith exitTransition
}
