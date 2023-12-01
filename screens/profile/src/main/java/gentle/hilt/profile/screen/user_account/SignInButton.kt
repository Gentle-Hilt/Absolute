package gentle.hilt.profile.screen.user_account

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.firebase.ui.auth.AuthUI
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.strings.strings
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.profile.ProfileScreenVM
import gentle.hilt.profile.screen.authentication.authenticationLauncher

@Composable
fun SignInButton(
    viewModel: ProfileScreenVM,
    modifier: Modifier
) {
    val authLauncher = authenticationLauncher(viewModel)

    Button(
        colors = ButtonDefaults.buttonColors(MaterialTheme.themeColors.icons),
        modifier = modifier,
        onClick = { authLauncher.launch(viewModel.auth()) }
    ) {
        Text(
            text = strings.signIn,
            fontSize = FontSizes.textFont.sp,
            color = MaterialTheme.themeColors.contrastText,
            modifier = Modifier
        )
    }
}