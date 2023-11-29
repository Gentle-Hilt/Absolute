package gentle.hilt.data.cart

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gentle.hilt.data.cart.CartDataBase.Companion.CART_DATABASE_VERSION
import gentle.hilt.data.converters.CartConverter
import gentle.hilt.data.converters.UiConverter


@Database(
    entities = [CartEntity::class],
    version = CART_DATABASE_VERSION
)
@TypeConverters(CartConverter::class)
abstract class CartDataBase: RoomDatabase() {
    abstract fun dao(): CartDao

    companion object {
        const val CART_DATABASE_VERSION = 1
    }
}