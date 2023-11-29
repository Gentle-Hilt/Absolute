package gentle.hilt.data.res.drawables.drawhelpers

import android.content.res.Resources
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope

fun DrawScope.size(size: Float): Float {
    val canvas = scaledSize(100f)
    return canvas.scaleBy(size).width
}

// 10f = 10%
// 140f = 140%
fun DrawScope.scaledSize(scaleFactor: Float): Size {
    return size.scaleBy(scaleFactor)
}

fun Size.scaleBy(factor: Float): Size {
    val scale = factor / 100f
    return Size(width * scale, height * scale)
}

val Int.px: Float
    get() {
        val density = Resources.getSystem().displayMetrics.density
        return this * density
    }
