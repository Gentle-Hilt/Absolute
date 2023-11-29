package gentle.hilt.data.server_driven_ui

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUiEntity(ui: UiEntity)

    @Update
    suspend fun updateEntity(ui: UiEntity)

    @Query("DELETE FROM ui_table")
    suspend fun deleteUnEntity()

    @Query("SELECT * FROM ui_table")
    fun observeUi(): Flow<UiEntity?>
}
