package gentle.hilt.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import gentle.hilt.data.server_driven_ui.categories.CategoriesScreenData
import gentle.hilt.data.server_driven_ui.menu.MenuScreenData

class UiConverter {

    private val gson = Gson()


    @TypeConverter
    fun fromCategoriesData(data: CategoriesScreenData): String = gson.toJson(data)

    @TypeConverter
    fun toCategoriesData(json: String): CategoriesScreenData {
        val type = object : TypeToken<CategoriesScreenData>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromMenuData(data: MenuScreenData): String = gson.toJson(data)

    @TypeConverter
    fun toMenuData(json: String): MenuScreenData {
        val type = object : TypeToken<MenuScreenData>() {}.type
        return gson.fromJson(json, type)
    }
}
