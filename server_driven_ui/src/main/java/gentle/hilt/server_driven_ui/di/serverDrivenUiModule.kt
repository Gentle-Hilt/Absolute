package gentle.hilt.server_driven_ui.di

import gentle.hilt.server_driven_ui.SharedUiViewModel
import org.koin.dsl.module

val serverDrivenUiModule = module {
    single { SharedUiViewModel(uiRepository = get(), dataStore = get()) }
}
