package gentle.hilt.data.res.drawables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import gentle.hilt.data.res.drawables.drawhelpers.size

class SearchIconPainter : Painter() {
    // Painter do not support colors like that, make tint or anything else, or use it directly as Canvas
    private val activatedState: Color = Color(0xFF3364E0)
    private val deactivatedState: Color = Color(0XFFA5A9B2)
    private val isSelected = true

    // Apply size with modifier
    override val intrinsicSize: Size = Size(30f, 30f)

    override fun DrawScope.onDraw() {
        drawCircle(
            center = Offset(size(45f), size(45f)),
            radius = size(23f),
            color = if (isSelected) activatedState else deactivatedState,
            style = Stroke(width = size(8f))
        )

        drawLine(
            start = Offset(size(80f), size(80f)),
            end = Offset(size(70f), size(70f)),
            cap = StrokeCap.Round,
            strokeWidth = size(8f),
            color = if (isSelected) activatedState else deactivatedState
        )
    }
}
