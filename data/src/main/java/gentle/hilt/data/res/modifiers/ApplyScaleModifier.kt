package gentle.hilt.data.res.modifiers


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer


fun Modifier.applyScaleModifier(
    isSelected:
    Boolean,
    scale: Float
): Modifier = graphicsLayer(
        scaleX = if (isSelected) scale else 1f,
        scaleY = if (isSelected) scale else 1f
    )


