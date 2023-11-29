package gentle.hilt.data.res.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val text: Color = Color.Unspecified,
    val contrastText: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val bottomNavigation: Color = Color.Unspecified,
    val icons: Color = Color.Unspecified,
    val fadeIcons: Color = Color.Unspecified,
)


// Read staticCompositionLocalOf description
val LocalColors = staticCompositionLocalOf { CustomColors() }