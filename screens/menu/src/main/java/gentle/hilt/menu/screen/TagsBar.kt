package gentle.hilt.menu.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.themes.themeColors

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TagsBar(
    tags: List<String>,
    selectedTags: List<String>,
    modifier: Modifier,
    onTagSelected: (List<String>) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        tags.distinct().forEach { tag ->
            val isSelected = selectedTags.contains(tag)

            Card(
                backgroundColor = if (isSelected) MaterialTheme.themeColors.icons else MaterialTheme.themeColors.bottomNavigation,
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    val newTags = if (isSelected) {
                        selectedTags - tag
                    } else {
                        selectedTags + tag
                    }
                    onTagSelected(newTags)
                },

                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = tag,
                    color = MaterialTheme.themeColors.text,
                    fontSize = FontSizes.titlesFont.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}