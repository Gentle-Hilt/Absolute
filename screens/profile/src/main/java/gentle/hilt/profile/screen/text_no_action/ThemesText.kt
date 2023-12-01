package gentle.hilt.profile.screen.text_no_action

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors

@Composable
internal fun ThemesText(
    modifier: Modifier
) {
    Text(
        color = MaterialTheme.themeColors.text,
        text = strings.themes,
        fontSize = FontSizes.titlesFont.sp,
        modifier = modifier
    )
}