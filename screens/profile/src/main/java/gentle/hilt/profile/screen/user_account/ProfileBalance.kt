package gentle.hilt.profile.screen.user_account

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors

@Composable
internal fun ProfileBalance(
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            color = MaterialTheme.themeColors.text,
            text = strings.balance,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.SemiBold,
            fontSize = FontSizes.titlesFont.sp
        )

        Text(
            color = MaterialTheme.themeColors.text,
            text = "0$",
            fontSize =  FontSizes.textFont.sp
        )
    }
}