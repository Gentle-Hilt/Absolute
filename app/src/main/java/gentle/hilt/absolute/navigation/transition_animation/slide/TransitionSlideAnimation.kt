package gentle.hilt.absolute.navigation.transition_animation.slide

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.stack.StackEvent
import cafe.adriel.voyager.navigator.Navigator
import gentle.hilt.data.res.animations.content_transforms.contentTransformForTransitionAnimationIn
import gentle.hilt.data.res.animations.content_transforms.contentTransformForTransitionAnimationOut

object TransitionSlideAnimation : CustomScreenAnimation {
    override fun screenAnimation(
        scope: AnimatedContentTransitionScope<Screen>,
        navigator: Navigator
    ): ContentTransform {
        return when (navigator.lastEvent) {
            StackEvent.Pop -> contentTransformForTransitionAnimationIn()
            else -> contentTransformForTransitionAnimationOut()
        }
    }
}
