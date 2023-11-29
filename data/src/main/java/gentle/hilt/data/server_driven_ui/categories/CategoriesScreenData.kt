package gentle.hilt.data.server_driven_ui.categories

data class CategoriesScreenData(
    val uiConfiguration: CategoriesUiConfiguration = CategoriesUiConfiguration(),
    val categoriesList: CategoriesList = CategoriesList()
)