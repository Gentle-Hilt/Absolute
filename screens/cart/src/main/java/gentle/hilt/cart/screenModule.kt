package gentle.hilt.cart

import cafe.adriel.voyager.core.registry.screenModule
import gentle.hilt.navigation.SharedScreen

val categoriesScreen = screenModule {
    register<SharedScreen.CartScreen> {
        CartScreen()
    }
}