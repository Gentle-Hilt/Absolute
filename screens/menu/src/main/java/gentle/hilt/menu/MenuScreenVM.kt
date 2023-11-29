package gentle.hilt.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.cart.CartEntity
import gentle.hilt.data.cart.CartRepository
import gentle.hilt.data.cart.GroupedMenuItem
import gentle.hilt.data.server_driven_ui.menu.MenuItem
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class MenuScreenVM(
    private val repository: CartRepository
): ViewModel() {

    fun addMenuItemToCart(menuItem: MenuItem) {
        viewModelScope.launch {
            val currentCart = repository.observeCartEntity().firstOrNull() ?: CartEntity()
            val updatedCart = updateCart(currentCart, menuItem)
            repository.insertCartEntity(updatedCart)
        }
    }

    private fun updateCart(currentCart: CartEntity, menuItem: MenuItem): CartEntity {
        val updatedGroupedList = currentCart.groupedList.toMutableList()
        val groupToUpdate = updatedGroupedList.find { it.id == menuItem.id }

        if (groupToUpdate != null) {
            groupToUpdate.quantity++
        } else {
            val newGroup = groupItems(mutableListOf(menuItem)).first()
            updatedGroupedList.add(newGroup)
        }

        return currentCart.copy(groupedList = updatedGroupedList)
    }

    private fun groupItems(listMenuItems: List<MenuItem>): List<GroupedMenuItem> {
        return listMenuItems
            .groupBy { it.id }
            .map { (id, items) ->
                val totalQuantity = items.size
                val totalPrice = totalQuantity * (items.firstOrNull()?.price ?: 0)
                val image = items.firstOrNull()?.image.orEmpty()
                val description = items.firstOrNull()?.description.orEmpty()
                val title = items.firstOrNull()?.title.orEmpty()

                GroupedMenuItem(id, totalQuantity, price = totalPrice, image, description, title)
            }
    }

}