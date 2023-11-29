package gentle.hilt.data.res.drawables

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import gentle.hilt.data.res.drawables.drawhelpers.px
import gentle.hilt.data.res.drawables.drawhelpers.size

class CartIconPainter : Painter() {
    // Painter do not support colors like that, make tint or anything else, or use it directly as Canvas
    private val activatedState: Color = Color(0xFF3364E0)
    private val deactivatedState: Color = Color(0XFFA5A9B2)
    private val isSelected = true

    // Apply size with modifier
    override val intrinsicSize: Size = Size(30.px, 30.px)

    override fun DrawScope.onDraw() {
        val path = Path().apply {
            moveTo(size(35f), size(92f))
            lineTo(size(65f), size(92f))

            quadraticBezierTo(size(77f), size(92f), size(80f), size(77f))
            lineTo(size(88f), size(42f))

            addRoundRect(
                roundRect = RoundRect(
                    top = size(25f),
                    bottom = size(42f),
                    left = size(5f),
                    right = size(95f),
                    bottomLeftCornerRadius = CornerRadius(size(9f)),
                    topRightCornerRadius = CornerRadius(size(9f)),
                    bottomRightCornerRadius = CornerRadius(size(9f)),
                    topLeftCornerRadius = CornerRadius(size(9f))
                )
            )

            moveTo(size(12f), size(42f))
            lineTo(size(20f), size(77f))
            quadraticBezierTo(size(23f), size(92f), size(35f), size(92f))

            moveTo(size(21f), size(25f))
            lineTo(size(36f), size(8f))

            moveTo(size(78f), size(25f))
            lineTo(size(64f), size(8f))

            moveTo(size(41f), size(53f))
            lineTo(size(41f), size(74f))

            moveTo(size(59f), size(53f))
            lineTo(size(59f), size(74f))
        }

        drawPath(
            path = path,
            color = if (isSelected) activatedState else deactivatedState,
            style = Stroke(size(7f), join = StrokeJoin.Round, cap = StrokeCap.Round)
        )
    }
}
