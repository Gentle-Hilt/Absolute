package gentle.hilt.server_driven_ui.di

import gentle.hilt.server_driven_ui.SharedUiViewModel
import org.koin.dsl.module
import gentle.hilt.server_driven_ui.worker.UpdateDataBaseWorker
import org.koin.androidx.workmanager.dsl.workerOf

val serverDrivenUiModule = module {
    workerOf(::UpdateDataBaseWorker)
    single { SharedUiViewModel(uiRepository = get(), cartRepository = get(), dataStore = get()) }
}
