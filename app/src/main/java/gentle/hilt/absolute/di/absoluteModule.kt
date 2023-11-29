package gentle.hilt.absolute.di

import gentle.hilt.data.di.authModule
import gentle.hilt.data.di.dataModule
import gentle.hilt.server_driven_ui.di.serverDrivenUiModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import gentle.hilt.menu.MenuScreenVM

val absoluteModule = module {
    includes(dataModule, serverDrivenUiModule, authModule)

    viewModelOf(::MenuScreenVM)
}
