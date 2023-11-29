package gentle.hilt.data.server_driven_ui.categories

import android.os.Parcelable
import gentle.hilt.data.server_driven_ui.menu.MenuItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Long? = null,
    val title: String? = "Default category title",
    val image: String? = "https://cdn.discordapp.com/attachments/841699971580952586/1134015539077992478/image.png",
    val products: List<MenuItem> = listOf(MenuItem()),
) : Parcelable
