package gentle.hilt.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import gentle.hilt.data.cart.GroupedMenuItem

class CartConverter {
    @TypeConverter
    fun fromString(value: String): MutableList<GroupedMenuItem> {
        val listType = object : TypeToken<MutableList<GroupedMenuItem>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: MutableList<GroupedMenuItem>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}