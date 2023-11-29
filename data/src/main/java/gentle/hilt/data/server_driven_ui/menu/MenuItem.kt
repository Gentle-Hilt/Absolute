package gentle.hilt.data.server_driven_ui.menu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItem(
    val id: Long? = null,
    val title: String? = "The title was null or wrong type",
    val image: String? = "https://cdn.discordapp.com/attachments/841699971580952586/1134015539077992478/image.png",
    val description: String? = "Default Item description",
    val price: Long? = null,
    val tag: String? = ""
) : Parcelable
