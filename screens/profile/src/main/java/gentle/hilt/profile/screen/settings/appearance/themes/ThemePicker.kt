package gentle.hilt.profile.screen.settings.appearance.themes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.themes.Themes.Companion.themeList


@Composable
fun ThemePickerSetting(
    dataStore: DataStoreManager, modifier: Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier,
        content = {
            items(themeList) { theme ->
                ThemePickerItem(
                    dataStore = dataStore,
                    theme = theme
                )
            }

        })
}