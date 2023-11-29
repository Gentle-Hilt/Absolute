package gentle.hilt.menu


import android.os.Parcelable
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.data.server_driven_ui.categories.Category
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.koin.core.component.KoinComponent


@Parcelize
data class MenuScreen(val category: Category) : Screen, Parcelable, KoinComponent {

    @IgnoredOnParcel
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {


    }
}






