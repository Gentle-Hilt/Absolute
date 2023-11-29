package gentle.hilt.data.server_driven_ui.menu

import kotlin.math.absoluteValue

data class MenuUiConfiguration(
    val listType: String = "",
    val columnsInGrid: Int = 2,
    val itemHeight: Int = 100,
    val itemWidth: Int = 100
){

    fun applyCorrections(): MenuUiConfiguration {
        return MenuUiConfiguration(
            listType = handleSpellingMistakesOfListType(listType),
            columnsInGrid = handleZeroAndNegativeNumberFromDataBase(columnsInGrid),
            itemHeight = handleZeroAndNegativeNumberFromDataBase(itemHeight),
            itemWidth = handleZeroAndNegativeNumberFromDataBase(itemWidth)
        )
    }

    private fun handleSpellingMistakesOfListType(listType: String?): String {
        return when (listType?.lowercase()) {
            "grid", "gri", "gr" -> "grid"
            "list", "lis", "li" -> "list"
            else -> "list"
        }
    }

    private fun handleZeroAndNegativeNumberFromDataBase(value: Number?): Int {
        return when (value) {
            is Int -> value.takeIf { it != 0 }?.absoluteValue?.coerceAtLeast(2) ?: 2
            is Long -> value.takeIf { it != 0L }?.absoluteValue?.coerceAtLeast(2L)?.toInt() ?: 2
            is Double -> value.takeIf { it != 0.0 }?.absoluteValue?.coerceAtLeast(2.0)?.toInt() ?: 2
            else -> 2
        }
    }
}