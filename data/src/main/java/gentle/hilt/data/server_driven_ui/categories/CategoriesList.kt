package gentle.hilt.data.server_driven_ui.categories

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoriesList(
    val data: List<Category> = emptyList()
) : Parcelable
