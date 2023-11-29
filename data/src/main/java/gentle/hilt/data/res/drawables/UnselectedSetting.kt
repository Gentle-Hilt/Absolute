package gentle.hilt.data.res.drawables

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import gentle.hilt.data.res.drawables.drawhelpers.size

class UnselectedSettingPainter : Painter() {
    // Painter do not support colors like that, make tint or anything else, or use it directly as Canvas
    private val activatedState: Color = Color(0xFF3364E0)


    // Apply size with modifier
    override val intrinsicSize: Size = Size(30f, 30f)

    override fun DrawScope.onDraw() {
        drawCircle(
            center = Offset(size(50f), size(50f)),
            radius = size(41f),
            color = activatedState ,
            style = Stroke(width = size(12f))
        )
    }
}
