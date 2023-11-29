package gentle.hilt.data.res.strings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

val strings: Strings
    @Composable
    @ReadOnlyComposable
    get() = LocalStrings.current
