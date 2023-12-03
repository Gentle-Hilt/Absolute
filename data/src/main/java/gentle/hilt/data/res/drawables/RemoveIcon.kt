package gentle.hilt.data.res.drawables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import gentle.hilt.data.res.drawables.drawhelpers.size

class RemoveIcon : Painter() {
    // Painter do not support colors like that, make tint or anything else, or use it directly as Canvas
    private val activatedState: Color = Color(0xFF3364E0)

    // Apply size with modifier
    override val intrinsicSize: Size = Size(30f, 30f)

    override fun DrawScope.onDraw() {
        drawLine(
            start = Offset(size(0f), size(50f)),
            end = Offset(size(100f), size(50f)),
            cap = StrokeCap.Round,
            strokeWidth = size(15f),
            color = activatedState
        )
    }
}
