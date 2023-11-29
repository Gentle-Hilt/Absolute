package gentle.hilt.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.cart.CartEntity
import gentle.hilt.data.cart.CartRepository
import gentle.hilt.data.cart.GroupedMenuItem
import gentle.hilt.data.history.HistoryEntity
import gentle.hilt.data.history.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HistoryScreenVM(
    private val historyRepository: HistoryRepository,
    private val cartRepository: CartRepository
): ViewModel() {


    private val _historyState = MutableStateFlow<HistoryEntity?>(null)
    val historyState: StateFlow<HistoryEntity?> = _historyState

    init {
        observeHistory()
    }

    private fun observeHistory(){
        viewModelScope.launch {
            historyRepository.observeHistory().collectLatest { history->
                _historyState.value = history
            }
        }
    }

    fun reorder(list:List<GroupedMenuItem>){
        viewModelScope.launch {
            cartRepository.clearCart()
            cartRepository.insertCartEntity(CartEntity(groupedList = list.toMutableList()))
        }
    }
}