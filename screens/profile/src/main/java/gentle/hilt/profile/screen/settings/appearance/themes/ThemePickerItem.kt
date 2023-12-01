package gentle.hilt.profile.screen.settings.appearance.themes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import gentle.hilt.data.datastore.MagicNumbers
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.themes.Themes
import gentle.hilt.data.res.themes.Themes.Companion.getThemeNumber
import gentle.hilt.data.res.themes.default.defaultThemeDark
import gentle.hilt.data.res.themes.default.defaultThemeLight
import gentle.hilt.data.res.themes.green_apple.greenAppleDark
import gentle.hilt.data.res.themes.green_apple.greenAppleLight
import gentle.hilt.data.res.themes.tako.takoDark
import gentle.hilt.data.res.themes.tako.takoLight
import gentle.hilt.data.res.themes.themeColors
import kotlinx.coroutines.launch
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_AUTO

@Composable
fun ThemePickerItem(
    dataStore: DataStoreManager,
    theme: Themes,
) {
    val coroutineScope = rememberCoroutineScope()
    val selectedTheme by dataStore.readTheme.collectAsState(initial = 1)
    val selectedDarkMode by dataStore.readDarkMode.collectAsStateWithLifecycle(initialValue = DARK_MODE_AUTO)

    val darkMode = when (selectedDarkMode) {
        DARK_MODE_AUTO -> isSystemInDarkTheme()
        MagicNumbers.DARK_MODE_OFF -> false
        MagicNumbers.DARK_MODE_ON -> true
        else -> isSystemInDarkTheme()
    }

    val currentThemes = when (theme) {
        Themes.DefaultThemes -> if (darkMode) defaultThemeDark else defaultThemeLight
        Themes.GreenAppleThemes -> if (darkMode) greenAppleDark else greenAppleLight
        Themes.TakoThemes -> if (darkMode) takoDark else takoLight
    }

    ConstraintLayout(
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(10))
            .border(
                shape = RoundedCornerShape(10),
                width = 3.dp,
                color = if (getThemeNumber(theme) == selectedTheme) MaterialTheme.themeColors.icons else Color.Unspecified,
            )
            .clickable {
                coroutineScope.launch {
                    dataStore.saveTheme(getThemeNumber(theme))
                }
            }
    ) {
        val (mainColor, backgroundColor) = createRefs()


        Box(
            modifier = Modifier
                .background(currentThemes.icons)
                .constrainAs(mainColor) {
                    start.linkTo(parent.start)
                    end.linkTo(backgroundColor.start)
                    centerVerticallyTo(parent)


                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints

                },
        )

        Box(
            modifier = Modifier
                .background(currentThemes.background)
                .constrainAs(backgroundColor) {
                    start.linkTo(mainColor.end)
                    end.linkTo(parent.end)
                    centerVerticallyTo(parent)

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                })
    }
}
