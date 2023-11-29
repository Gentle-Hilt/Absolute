package gentle.hilt.data.res.themes

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import gentle.hilt.data.res.colors.CustomColors
import gentle.hilt.data.res.colors.LocalColors

val MaterialTheme.themeColors: CustomColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
