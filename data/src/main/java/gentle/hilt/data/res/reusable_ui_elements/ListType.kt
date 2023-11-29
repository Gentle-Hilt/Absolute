package gentle.hilt.data.res.reusable_ui_elements

sealed interface ListType {
    data object List : ListType
    data class Grid(val columns: Int) : ListType
}
