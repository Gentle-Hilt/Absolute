package gentle.hilt.profile.screen.settings.appearance.dark_mode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.drawables.SelectedSettingPainter
import gentle.hilt.data.res.drawables.UnselectedSettingPainter
import gentle.hilt.data.res.themes.themeColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
inline fun DarkModeDialogItem(
    selectedDarkMode: Int,
    dataStore: DataStoreManager,
    action: Int,
    text: String,
    crossinline click: () -> Unit,
    coroutineScope:CoroutineScope = rememberCoroutineScope()
) {


    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .clickable {
            coroutineScope.launch {
                click()
                dataStore.saveDarkMode(action)
            }
        }
    ) {
        val (iconRef, textRef) = createRefs()

        Icon(
            tint = if(action == selectedDarkMode) MaterialTheme.themeColors.icons else MaterialTheme.themeColors.fadeIcons,
            painter = if(action == selectedDarkMode) SelectedSettingPainter() else UnselectedSettingPainter(),
            contentDescription = "currentTabTitle",
            modifier = Modifier.size(30.dp).constrainAs(iconRef){
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 30.dp)
                centerVerticallyTo(parent)

            }
        )

        Text(
            fontSize = 20.sp,
            text = text,
            color = MaterialTheme.themeColors.text,
            modifier = Modifier.constrainAs(textRef){
                start.linkTo(iconRef.end, margin = 30.dp)
                centerVerticallyTo(iconRef)
            }
        )

    }
}
