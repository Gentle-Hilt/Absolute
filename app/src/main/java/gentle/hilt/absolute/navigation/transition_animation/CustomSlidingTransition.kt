package gentle.hilt.absolute.navigation.transition_animation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.stack.StackEvent
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScreenTransition
import cafe.adriel.voyager.transitions.ScreenTransitionContent
import gentle.hilt.absolute.navigation.transition_animation.slide.CustomScreenAnimation
import gentle.hilt.absolute.navigation.transition_animation.slide.TransitionSlideAnimation

@Composable
fun CustomSlidingTransition(
    navigator: Navigator,
    animation: CustomScreenAnimation = TransitionSlideAnimation,
    content: ScreenTransitionContent = { it.Content() }
) {
    ScreenTransition(
        navigator = navigator,
        content = content,
        transition = {
            // Find out which screen defines the transition
            val transitionSource = when (navigator.lastEvent) {
                StackEvent.Pop, StackEvent.Replace -> initialState
                StackEvent.Idle, StackEvent.Push -> targetState
            }

            // Get the transition from the screen, if it is providing any
            val screenTransition = (transitionSource as? CustomScreenAnimation)
                ?.screenAnimation(this, navigator)
                ?: animation.screenAnimation(this, navigator)

            // Set the zIndex for the transition:
            // -> screens higher up on the stack must rendered on top of screens below
            // during transitions, this is important.
            // We use the index of the item to determine the zIndex in the UI
            val stackSize = navigator.items.size
            screenTransition.targetContentZIndex = when (navigator.lastEvent) {
                // Make sure that content that's popped is rendered on top
                StackEvent.Pop, StackEvent.Replace -> (stackSize - 1)
                // Make sure that content that's pushed is rendered on top
                StackEvent.Idle, StackEvent.Push -> stackSize
            }.toFloat()

            // Return the transition
            screenTransition
        }
    )
}
