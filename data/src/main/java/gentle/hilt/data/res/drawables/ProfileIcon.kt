package gentle.hilt.data.res.drawables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import gentle.hilt.data.res.drawables.drawhelpers.size

class ProfileIconPainter : Painter() {
    // Painter do not support colors like that, make tint or anything else, or use it directly as Canvas
    private val activatedState: Color = Color(0xFF3364E0)
    private val deactivatedState: Color = Color(0XFFA5A9B2)
    private val isSelected = true

    // Apply size with modifier
    override val intrinsicSize: Size = Size(30f, 30f)

    override fun DrawScope.onDraw() {
        drawCircle(
            center = Offset(size(50f), size(50f)),
            radius = size(41f),
            color = if (isSelected) activatedState else deactivatedState,
            style = Stroke(width = size(8f))
        )

        drawCircle(
            center = Offset(size(50f), size(40f)),
            radius = size(14f),
            color = if (isSelected) activatedState else deactivatedState,
            style = Stroke(width = size(8f))
        )

        val path = Path().apply {
            moveTo(size(20f), size(78f))
            cubicTo(size(30f), size(60f), size(70f), size(60f), size(80f), size(78f))
        }

        drawPath(
            path = path,
            color = if (isSelected) activatedState else deactivatedState,
            style = Stroke(size(8f), join = StrokeJoin.Round, cap = StrokeCap.Round)
        )
    }
}
