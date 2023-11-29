package gentle.hilt.data.history

import androidx.room.Entity
import androidx.room.PrimaryKey
import gentle.hilt.data.cart.GroupedMenuItem

@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val history: MutableList<BoughtItem> = mutableListOf()
)


data class BoughtItem(
    val price: Int = 0,
    val date: String = "",
    val items: List<GroupedMenuItem> = emptyList()
)
