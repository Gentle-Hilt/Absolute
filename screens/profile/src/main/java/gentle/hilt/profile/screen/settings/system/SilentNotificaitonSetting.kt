package gentle.hilt.profile.screen.settings.system

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors
import kotlinx.coroutines.launch

@Composable
internal fun SilentNotificationSetting(
    dataStore: DataStoreManager,
    modifier: Modifier
) {
    val silentNotificationState by dataStore.readSilentUpdates.collectAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            color = MaterialTheme.themeColors.text,
            text = strings.silentNotifications,
            modifier = Modifier.weight(1f),
            fontSize = FontSizes.titlesFont.sp
        )

        Switch(
            colors = SwitchDefaults.colors(MaterialTheme.themeColors.icons),
            checked = silentNotificationState,
            onCheckedChange = { isChecked ->
                coroutineScope.launch {
                    dataStore.saveShouldTurnSilentUpdates(isChecked)
                }
            },
        )
    }

}