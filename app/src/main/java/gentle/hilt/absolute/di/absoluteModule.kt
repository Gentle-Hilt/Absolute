package gentle.hilt.absolute.di

import gentle.hilt.data.di.dataModule
import gentle.hilt.server_driven_ui.di.serverDrivenUiModule
import org.koin.dsl.module

val absoluteModule = module {
    includes(dataModule, serverDrivenUiModule)
}
