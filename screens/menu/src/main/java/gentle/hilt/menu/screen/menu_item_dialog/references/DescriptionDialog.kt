package gentle.hilt.menu.screen.menu_item_dialog.references

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.themes.themeColors

@Composable
fun DescriptionDialog(description: String?, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            color = MaterialTheme.themeColors.text,
            text = description ?: "",
            textAlign = TextAlign.Center,
            fontSize = 17.sp,
            maxLines = 2,
            minLines = 2
        )
    }
}