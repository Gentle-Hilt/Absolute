package gentle.hilt.absolute.di

import gentle.hilt.cart.CartScreenVM
import gentle.hilt.data.di.authModule
import gentle.hilt.data.di.dataModule
import gentle.hilt.history.HistoryScreenVM
import gentle.hilt.menu.MenuScreenVM
import gentle.hilt.server_driven_ui.di.serverDrivenUiModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val absoluteModule = module {
    includes(dataModule, serverDrivenUiModule, authModule)

    viewModelOf(::MenuScreenVM)
    viewModelOf(::CartScreenVM)
    viewModelOf(::HistoryScreenVM)
}
