package gentle.hilt.profile

import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.profile.screen.settings.appearance.themes.ThemePickerSetting
import gentle.hilt.profile.screen.settings.system.SilentNotificationSetting
import gentle.hilt.profile.screen.text_no_action.AppearanceText
import gentle.hilt.profile.screen.text_no_action.SystemText
import gentle.hilt.profile.screen.text_no_action.ThemesText
import gentle.hilt.profile.screen.user_account.LogOutButton
import gentle.hilt.profile.screen.user_account.ProfileBalance
import gentle.hilt.profile.screen.user_account.ProfileImage
import gentle.hilt.profile.screen.user_account.ProfileName
import gentle.hilt.profile.screen.user_account.ProfilePoints
import gentle.hilt.profile.screen.user_account.SignInButton
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.koin.androidx.compose.getViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


@Parcelize
class ProfileScreen : Screen, Parcelable, KoinComponent {


    @IgnoredOnParcel
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: ProfileScreenVM = getViewModel()
        val dataStore: DataStoreManager by inject()
        val userState by viewModel.userState.collectAsStateWithLifecycle()

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
                .background(color = MaterialTheme.themeColors.background)
        ) {
            val (profileSignIn, profileLogOut, profileImage, profileName, profilePoints, profileBalance) = createRefs()
            val (systemText, themesText, appearanceText) = createRefs()
            val (darkModeSetting, themePickerSetting, silentNotificationSetting) = createRefs()

            ProfileImage(
                image = userState?.photoUrl,
                modifier = Modifier.constrainAs(profileImage) {
                    top.linkTo(parent.top, margin = 5.dp)
                    start.linkTo(parent.start, margin = 5.dp)

                    width = Dimension.value(150.dp)
                    height = Dimension.value(150.dp)
                })

            ProfileName(
                title = userState?.displayName,
                modifier = Modifier.constrainAs(profileName) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(profileImage.end, margin = 5.dp)
                    end.linkTo(parent.end)

                })

            SignInButton(
                viewModel = viewModel,
                modifier = Modifier.constrainAs(profileSignIn) {
                    top.linkTo(parent.top)
                    start.linkTo(profileImage.end)
                    end.linkTo(parent.end)
                    bottom.linkTo(profilePoints.top)

                    width = Dimension.value(100.dp)
                    height = Dimension.value(37.dp)

                })

            LogOutButton(
                viewModel = viewModel,
                modifier = Modifier.constrainAs(profileLogOut) {
                    top.linkTo(profileSignIn.bottom, margin = 5.dp)
                    start.linkTo(profileSignIn.start)
                    end.linkTo(profileSignIn.end)

                    width = Dimension.value(100.dp)
                    height = Dimension.value(37.dp)
                })

            ProfilePoints(
                modifier = Modifier.constrainAs(profilePoints) {
                    top.linkTo(profileImage.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)

                    width = Dimension.fillToConstraints
                })

            ProfileBalance(
                modifier = Modifier.constrainAs(profileBalance) {
                    top.linkTo(profilePoints.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)

                    width = Dimension.fillToConstraints
                })

            SystemText(
                modifier = Modifier.constrainAs(systemText) {
                    top.linkTo(profileBalance.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 20.dp)

                    width = Dimension.fillToConstraints
                })

            SilentNotificationSetting(
                dataStore,
                modifier = Modifier.constrainAs(silentNotificationSetting) {
                    top.linkTo(systemText.bottom)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end, margin = 5.dp)

                    width = Dimension.fillToConstraints

                })

            AppearanceText(
                modifier = Modifier.constrainAs(appearanceText) {
                    top.linkTo(silentNotificationSetting.bottom)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                    height = Dimension.value(30.dp)
                })


            ThemesText(
                modifier = Modifier.constrainAs(themesText) {
                    top.linkTo(darkModeSetting.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                })

            ThemePickerSetting(
                dataStore = dataStore,
                modifier = Modifier.constrainAs(themePickerSetting) {
                    top.linkTo(themesText.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                    height = Dimension.value(150.dp)
                }
            )
        }
    }
}
