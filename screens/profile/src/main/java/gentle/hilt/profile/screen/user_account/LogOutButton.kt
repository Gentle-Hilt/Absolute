package gentle.hilt.profile.screen.user_account

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.profile.ProfileScreenVM

@Composable
fun LogOutButton(
    viewModel: ProfileScreenVM,
    modifier: Modifier
) {
    Button(
        colors = ButtonDefaults.buttonColors(MaterialTheme.themeColors.icons),
        modifier = modifier,
        onClick = {  viewModel.logOut() }
    ) {
        Text(
            text = strings.logOut,
            fontSize = FontSizes.textFont.sp,
            color = MaterialTheme.themeColors.contrastText,
            modifier = Modifier
        )
    }
}