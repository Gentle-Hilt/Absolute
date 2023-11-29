package gentle.hilt.categories.screen.category_item.references

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.themes.themeColors

@Composable
fun CategoryTitle(title: String?, modifier: Modifier) {
    Column(
        modifier = modifier.background(color = MaterialTheme.themeColors.bottomNavigation, RoundedCornerShape(10))
    ) {
        Text(
            text = title ?: "",
            fontFamily = Fonts.sans_serif,
            fontSize = FontSizes.titlesFont.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            minLines = 1,
            maxLines = 1,
            color = MaterialTheme.themeColors.text,
            modifier = Modifier.fillMaxWidth()
        )
    }
}