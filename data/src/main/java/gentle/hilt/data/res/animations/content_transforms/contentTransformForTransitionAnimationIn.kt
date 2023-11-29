package gentle.hilt.data.res.animations.content_transforms

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith

fun contentTransformForTransitionAnimationIn() :ContentTransform{
    val enterTransition = slideInHorizontally { -it / 2 }
    val exitTransition = slideOutHorizontally { it }

    return enterTransition togetherWith exitTransition
}