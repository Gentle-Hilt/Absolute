package gentle.hilt.data.di

import android.content.Context
import androidx.room.Room
import gentle.hilt.data.cart.CartDao
import gentle.hilt.data.cart.CartDataBase
import gentle.hilt.data.cart.CartRepository
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.history.HistoryDao
import gentle.hilt.data.history.HistoryDataBase
import gentle.hilt.data.history.HistoryRepository
import gentle.hilt.data.server_driven_ui.UiDao
import gentle.hilt.data.server_driven_ui.UiDataBase
import gentle.hilt.data.server_driven_ui.UiRepository
import org.koin.dsl.module

val dataModule = module{
    single { provideDataStoreManager(context = get()) }

    single { provideUiDao(database = get()) }
    single { provideUiRepository(dao = get()) }
    single { provideUiDataBase(context = get()) }

    single { provideCartDao(database = get()) }
    single { provideCartRepository(dao = get()) }
    single { provideCartDataBase(context = get()) }

    single { provideHistoryDao(database = get()) }
    single { provideHistoryRepository(dao = get())}
    single { provideHistoryDataBase(context = get())}
}

fun provideDataStoreManager(context: Context) = DataStoreManager(context)

fun provideUiDao(database: UiDataBase) = database.dao()
fun provideUiRepository(dao: UiDao) = UiRepository(dao)
fun provideUiDataBase(context: Context) = Room.databaseBuilder(
    context,
    UiDataBase::class.java,
    "ui_database"
).build()

fun provideCartDao(database: CartDataBase) = database.dao()
fun provideCartRepository(dao: CartDao) = CartRepository(dao)
fun provideCartDataBase(context: Context) = Room.databaseBuilder(
    context,
    CartDataBase::class.java,
    "cart_database"
).build()

fun provideHistoryDao(database: HistoryDataBase) = database.dao()
fun provideHistoryRepository(dao: HistoryDao) = HistoryRepository(dao)
fun provideHistoryDataBase(context: Context) = Room.databaseBuilder(
    context,
    HistoryDataBase::class.java,
    "history_database"
).build()