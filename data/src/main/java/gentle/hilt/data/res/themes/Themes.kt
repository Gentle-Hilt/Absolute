package gentle.hilt.data.res.themes

import gentle.hilt.data.datastore.MagicNumbers

sealed class Themes {
    data object DefaultThemes : Themes()
    data object GreenAppleThemes : Themes()
    data object TakoThemes : Themes()

    companion object {

        val themeList = listOf(DefaultThemes, GreenAppleThemes, TakoThemes)
        fun getThemeNumber(themes: Themes): Int {
            return when (themes) {
                is DefaultThemes -> MagicNumbers.DEFAULT_THEME
                is GreenAppleThemes -> MagicNumbers.GREEN_APPLE_THEME
                is TakoThemes -> MagicNumbers.TAKO_THEME
            }
        }
    }
}