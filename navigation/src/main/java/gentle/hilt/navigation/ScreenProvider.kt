package gentle.hilt.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import gentle.hilt.data.server_driven_ui.categories.Category


sealed class SharedScreen : ScreenProvider {
    data class MenuScreen(val category: Category): SharedScreen()
    data object CategoriesScreen: SharedScreen()
    data object CartScreen: SharedScreen()
}

