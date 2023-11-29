package gentle.hilt.categories

import cafe.adriel.voyager.core.registry.screenModule


import gentle.hilt.navigation.SharedScreen

val categoriesScreen = screenModule {
    register<SharedScreen.CategoriesScreen> {
        CategoriesScreen()
    }
}