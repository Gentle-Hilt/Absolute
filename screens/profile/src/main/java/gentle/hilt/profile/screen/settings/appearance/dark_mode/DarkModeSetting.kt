package gentle.hilt.profile.screen.settings.appearance.dark_mode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_AUTO
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_OFF
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_ON
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.font.FontSizes.textFont
import gentle.hilt.data.res.font.FontSizes.titlesFont
import gentle.hilt.data.res.custom_composables.DialogWithAnyTypeOfData
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors

@Composable
fun DarkModeSetting(
    dataStore: DataStoreManager,
    modifier: Modifier,
) {
    val darkModeSetting by dataStore.readDarkMode.collectAsStateWithLifecycle(initialValue = DARK_MODE_AUTO)
    var showDialog by remember { mutableStateOf(false) }

    val darkModeText = when (darkModeSetting) {
        DARK_MODE_AUTO -> strings.auto
        DARK_MODE_ON -> strings.turnedOn
        DARK_MODE_OFF -> strings.turnedOff
        else -> {
            strings.auto
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                showDialog = true
            },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy((-5).dp)
    ) {
        Text(
            color = MaterialTheme.themeColors.text,
            text = strings.darkMode,
            fontSize = titlesFont.sp,
            modifier = Modifier.padding(start = 20.dp)
        )

        Text(
            text = darkModeText,
            fontSize = textFont.sp,
            color = MaterialTheme.themeColors.fadeIcons,
            modifier = Modifier.padding(start = 20.dp)
        )
    }



    if (showDialog) {
        DialogWithAnyTypeOfData(
            uiContainer = { listOfItems ->
                Card(
                    backgroundColor = MaterialTheme.themeColors.background,
                    shape = RoundedCornerShape(10),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            color = MaterialTheme.themeColors.text,
                            text = strings.darkMode, fontSize = 25.sp, modifier = Modifier
                                .align(Alignment.Start)
                                .padding(top = 25.dp, start = 30.dp, bottom = 15.dp)
                        )

                        listOfItems()

                        TextButton(
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(20.dp),
                            onClick = { showDialog = false }) {
                            Text(text = strings.cancel, fontSize = titlesFont.sp, color = MaterialTheme.themeColors.icons)
                        }
                    }

                }
            },
            dialogActionsInOrder = listOf(
                Pair(DARK_MODE_AUTO, strings.systemAuto),
                Pair(DARK_MODE_OFF, strings.turnOff),
                Pair(DARK_MODE_ON, strings.turnOn),
            ),
            onDismissRequest = {
                showDialog = false
            },
            item = { action, text, onClick ->
                DarkModeDialogItem(
                    darkModeSetting,
                    dataStore,
                    action = action,
                    text = text,
                    click = { onClick() }
                )
            }
        )
    }

}