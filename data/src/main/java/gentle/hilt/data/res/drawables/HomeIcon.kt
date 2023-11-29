package gentle.hilt.data.res.drawables

import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import gentle.hilt.data.res.drawables.drawhelpers.size

class HomeIconPainter : Painter() {
    // Painter do not support colors like that, make tint or anything else, or use it directly as Canvas
    private val activatedState: Color = Color(0xFF3364E0)
    private val deactivatedState: Color = Color(0XFFA5A9B2)
    private val isSelected = true

    // Apply size with modifier
    override val intrinsicSize: Size = Size(30f, 30f)

    override fun DrawScope.onDraw() {
        val path = Path().apply {
            moveTo(size(25f), size(95f))

            lineTo(size(75f), size(95f))
            quadraticBezierTo(size(85f), size(95f), size(90f), size(80f))

            lineTo(size(95f), size(50f))
            quadraticBezierTo(size(97f), size(40f), size(87f), size(33f))

            lineTo(size(60f), size(10f))
            quadraticBezierTo(size(50f), size(2f), size(40f), size(10f))

            lineTo(size(10f), size(36f))
            quadraticBezierTo(size(3f), size(43f), size(5f), size(50f))

            lineTo(size(10f), size(80f))
            quadraticBezierTo(size(15f), size(95f), size(25f), size(95f))
        }

        val thickLineAtTheHouseCenter = Path().apply {
            moveTo(size(50f), size(80f))
            lineTo(size(50f), size(62f))
        }

        drawPath(
            path = path,
            color = if (isSelected) activatedState else deactivatedState,
            style = Stroke(
                width = size(8.5f),
                pathEffect = PathEffect.cornerPathEffect(5f)
            )
        )

        drawPath(
            path = thickLineAtTheHouseCenter,
            color = if (isSelected) activatedState else deactivatedState,
            style = Stroke(
                width = size(8.5f),
                pathEffect = PathEffect.cornerPathEffect(5f)
            )
        )
    }
}
