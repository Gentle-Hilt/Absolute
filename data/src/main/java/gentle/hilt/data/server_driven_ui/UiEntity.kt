package gentle.hilt.data.server_driven_ui

import androidx.room.Entity
import androidx.room.PrimaryKey
import gentle.hilt.data.server_driven_ui.categories.CategoriesScreenData
import gentle.hilt.data.server_driven_ui.menu.MenuScreenData

@Entity(tableName = "ui_table")
data class UiEntity(
    @PrimaryKey
    val id: Long = 0,
    val homeScreen: CategoriesScreenData = CategoriesScreenData(),
    val cartScreen: MenuScreenData = MenuScreenData()
)
