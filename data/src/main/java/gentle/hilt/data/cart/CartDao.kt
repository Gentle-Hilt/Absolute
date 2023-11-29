package gentle.hilt.data.cart

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartEntity(cart: CartEntity)

    @Query("DELETE FROM cart_table")
    suspend fun deleteCartEntity()

    @Query("SELECT * FROM cart_table")
    fun observeCart(): Flow<CartEntity?>

}