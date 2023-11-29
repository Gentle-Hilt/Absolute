package gentle.hilt.data.di

import android.content.Context
import androidx.room.Room
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.server_driven_ui.UiDao
import gentle.hilt.data.server_driven_ui.UiDataBase
import gentle.hilt.data.server_driven_ui.UiRepository
import org.koin.dsl.module

val dataModule = module{
    single { provideDataStoreManager(context = get()) }

    single { provideUiDao(database = get()) }
    single { provideUiRepository(dao = get()) }
    single { provideUiDataBase(context = get()) }
}

fun provideDataStoreManager(context: Context) = DataStoreManager(context)

fun provideUiDao(database: UiDataBase) = database.dao()
fun provideUiRepository(dao: UiDao) = UiRepository(dao)
fun provideUiDataBase(context: Context) = Room.databaseBuilder(
    context,
    UiDataBase::class.java,
    "ui_database"
).build()

