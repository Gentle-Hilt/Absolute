package gentle.hilt.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.cart.CartEntity
import gentle.hilt.data.cart.CartRepository
import gentle.hilt.data.history.BoughtItem
import gentle.hilt.data.history.HistoryEntity
import gentle.hilt.data.history.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.Date
import java.util.Locale

class CartScreenVM(
    private val cartRepository: CartRepository,
    private val historyRepository: HistoryRepository,
) : ViewModel() {

    private val _cartState = MutableStateFlow<CartEntity?>(null)
    val cartState: StateFlow<CartEntity?> = _cartState

    init {
        observerCart()
    }

    private fun observerCart() {
        viewModelScope.launch {
            cartRepository.observeCartEntity().collectLatest {
                _cartState.value = it
            }
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            cartRepository.clearCart()
            _cartState.value = null
        }
    }


    fun proceedPayment() {
        viewModelScope.launch {
            val historyEntity = historyRepository.observeHistory().first()
            val dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault())
            val formattedDate = dateFormat.format(Date())


            val newBoughtItem = BoughtItem(
                price = cartState.value?.price?.toInt() ?: 0,
                date = formattedDate,
                items =  cartState.value?.groupedList?: emptyList()
            )

            historyEntity?.history?.add(newBoughtItem)

            if (historyEntity != null) {
                historyRepository.updateHistory(historyEntity)
            } else {
                historyRepository.addNewHistory(HistoryEntity(history = mutableListOf(newBoughtItem)))
            }
        }
    }

    fun updateQuantity(groupId: Long?, shouldIncrease: Boolean) {
        viewModelScope.launch {
            val currentCart = cartRepository.observeCartEntity().firstOrNull() ?: CartEntity()
            val updatedGroupedList = currentCart.groupedList
            val groupToUpdate = updatedGroupedList.find { it.id == groupId }

            groupToUpdate?.let { item ->
                when (shouldIncrease) {
                    true -> {
                        item.quantity++
                    }
                    false -> {
                        item.quantity--
                        if (item.quantity < 1) {
                            updatedGroupedList.remove(item)
                        }
                    }
                }

                val updatedCart = currentCart.copy(groupedList = updatedGroupedList)
                cartRepository.insertCartEntity(updatedCart)
            }
        }
    }


}