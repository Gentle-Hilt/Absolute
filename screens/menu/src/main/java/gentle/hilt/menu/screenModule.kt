package gentle.hilt.menu

import cafe.adriel.voyager.core.registry.screenModule
import gentle.hilt.navigation.SharedScreen

val menuScreen = screenModule {
    register<SharedScreen.MenuScreen> { provider ->
        MenuScreen(category = provider.category)

    }
}