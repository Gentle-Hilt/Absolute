package gentle.hilt.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import gentle.hilt.data.cart.GroupedMenuItem
import gentle.hilt.data.history.BoughtItem

class HistoryConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromBoughtItemList(value: MutableList<BoughtItem>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toBoughtItemList(value: String): MutableList<BoughtItem>? {
        val listType = object : TypeToken<MutableList<BoughtItem>>() {}.type
        return gson.fromJson(value, listType)
    }
}