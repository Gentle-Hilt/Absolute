package gentle.hilt.menu.screen.menu_item_dialog.references

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.strings.strings

import gentle.hilt.data.res.themes.themeColors

@Composable
fun DismissButtonDialog(onDismiss: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = { onDismiss() },
        modifier
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.themeColors.background)
                .padding(5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = strings.description_dismiss_dialog,
                tint = MaterialTheme.themeColors.text
            )
        }
    }
}
