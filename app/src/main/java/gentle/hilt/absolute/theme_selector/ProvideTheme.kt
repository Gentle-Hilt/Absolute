package gentle.hilt.absolute.theme_selector

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_AUTO
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_OFF
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_ON
import gentle.hilt.data.datastore.MagicNumbers.DEFAULT_THEME
import gentle.hilt.data.datastore.MagicNumbers.GREEN_APPLE_THEME
import gentle.hilt.data.datastore.MagicNumbers.TAKO_THEME
import gentle.hilt.data.res.colors.LocalColors
import gentle.hilt.data.res.themes.default.defaultThemeDark
import gentle.hilt.data.res.themes.default.defaultThemeLight
import gentle.hilt.data.res.themes.green_apple.greenAppleDark
import gentle.hilt.data.res.themes.green_apple.greenAppleLight
import gentle.hilt.data.res.themes.tako.takoDark
import gentle.hilt.data.res.themes.tako.takoLight

@Composable
fun ProvideThemes(
    dataStore: DataStoreManager,
    content: @Composable () -> Unit
) {
    val darkModePreferences by dataStore.readDarkMode.collectAsStateWithLifecycle(initialValue = DARK_MODE_AUTO)
    val selectedTheme by dataStore.readTheme.collectAsStateWithLifecycle(initialValue = DEFAULT_THEME)

    val darkMode = when (darkModePreferences) {
        DARK_MODE_AUTO -> isSystemInDarkTheme()
        DARK_MODE_OFF -> false
        DARK_MODE_ON -> true
        else -> isSystemInDarkTheme()
    }

    val theme = when (selectedTheme) {
        DEFAULT_THEME -> if (darkMode) defaultThemeDark else defaultThemeLight
        GREEN_APPLE_THEME -> if (darkMode) greenAppleDark else greenAppleLight
        TAKO_THEME -> if (darkMode) takoDark else takoLight
        else -> if (darkMode) defaultThemeDark else defaultThemeLight
    }

    CompositionLocalProvider(LocalColors provides theme) {
        MaterialTheme {
            content()
        }
    }
}
