package gentle.hilt.absolute.navigation.tabs

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.LocalAndroidTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import gentle.hilt.data.res.themes.themeColors

@Composable
fun RowScope.TabNavigationItem(
    tab: Tab,
    painter: Painter,
    iconSize: Dp = 30.dp,
    paddingBottom: Dp = 10.dp
) {
    val tabNavigator = LocalAndroidTabNavigator.current
    val currentTabTitle = tabNavigator.current.options.title
    val isSelected = tabNavigator.current.key == tab.key

    BottomNavigationItem(
        selectedContentColor = MaterialTheme.themeColors.icons,
        unselectedContentColor = MaterialTheme.themeColors.fadeIcons,
        label = {
            Text(
                maxLines = 1,
                text = tab.options.title,
                fontSize = if (isSelected) 16.sp else 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        },
        selected = isSelected,
        onClick = {
            if (tabNavigator.current != tab) {
                tabNavigator.updateTabHistory(currentTabTitle)
                tabNavigator.current = tab
            }
        },
        icon = {
            Icon(
                painter = painter,
                contentDescription = currentTabTitle,
                modifier = Modifier

                    .padding(
                        bottom = paddingBottom

                    )
                    .size(iconSize)
            )
        }

    )
}
