package gentle.hilt.data.cart

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    val identifier: Int? = null,

    val groupedList: MutableList<GroupedMenuItem> = mutableListOf(),
) {
    val price: Long
        get() {
            return calculateTotalPrice(groupedList)
        }

    companion object {
        private fun calculateTotalPrice(groupedList: List<GroupedMenuItem>): Long {
            return groupedList.sumOf { it.price * it.quantity }
        }
    }


}

data class GroupedMenuItem(
    val id: Long?,
    var quantity: Int,
    var price: Long,
    val image: String,
    val description: String,
    val title: String
)

