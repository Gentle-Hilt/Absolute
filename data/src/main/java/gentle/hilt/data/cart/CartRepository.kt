package gentle.hilt.data.cart

import kotlinx.coroutines.flow.Flow

class CartRepository(
    private val cartDao: CartDao
) {

    suspend fun insertCartEntity(cart: CartEntity) {
        cartDao.insertCartEntity(cart)
    }

    suspend fun clearCart() {
        cartDao.deleteCartEntity()
    }

    fun observeCartEntity(): Flow<CartEntity?> = cartDao.observeCart()
}