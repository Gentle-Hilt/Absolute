package gentle.hilt.data.server_driven_ui

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gentle.hilt.data.converters.UiConverter
import gentle.hilt.data.server_driven_ui.UiDataBase.Companion.UI_DATABASE_VERSION

@Database(
    entities = [UiEntity::class],
    version = UI_DATABASE_VERSION
)
@TypeConverters(UiConverter::class)
abstract class UiDataBase : RoomDatabase() {
    abstract fun dao(): UiDao

    companion object {
        const val UI_DATABASE_VERSION = 1
    }
}
