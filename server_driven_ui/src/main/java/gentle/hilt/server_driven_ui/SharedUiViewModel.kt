package gentle.hilt.server_driven_ui

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.server_driven_ui.UiEntity
import gentle.hilt.data.server_driven_ui.UiRepository
import gentle.hilt.data.server_driven_ui.categories.CategoriesList
import gentle.hilt.data.server_driven_ui.categories.CategoriesScreenData
import gentle.hilt.data.server_driven_ui.categories.CategoriesUiConfiguration
import gentle.hilt.data.server_driven_ui.categories.Category
import gentle.hilt.data.server_driven_ui.menu.MenuItem
import gentle.hilt.data.server_driven_ui.menu.MenuScreenData
import gentle.hilt.data.server_driven_ui.menu.MenuUiConfiguration
import gentle.hilt.server_driven_ui.logic.typeSafeDataClass
import gentle.hilt.server_driven_ui.logic.typeSafeNestedDataClass
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import timber.log.Timber


class SharedUiViewModel(
    private val uiRepository: UiRepository,
    private val dataStore: DataStoreManager
) : ViewModel() {
    private val dataBase = Firebase.database
    private val ui = dataBase.getReference("ui")

    private val _uiState = MutableStateFlow<UiEntity?>(null)
    val uiState: StateFlow<UiEntity?> = _uiState

    fun observeUpdatesFromRTDB(lifeCycleScope: LifecycleCoroutineScope) {
        lifeCycleScope.launch {
            dataStore.readShouldUpdateDataBase.collect { shouldUpdate ->
                if (shouldUpdate) {
                    val snapshot = ui.get().await()
                    val uiEntity = uiEntityListener(snapshot)


                    updateOrInsertUiEntity(uiEntity, lifeCycleScope)
                } else if (_uiState.value == null) {
                    Timber.d("Ui Loaded from Room - ViewModelInstance $this@SharedUiViewModel")
                    _uiState.value = uiRepository.observeUiEntity().first()
                }
            }
        }
    }

    private fun updateOrInsertUiEntity(ui: UiEntity, lifeCycleScope: LifecycleCoroutineScope) {
        lifeCycleScope.launch {
            val uiEntity = uiRepository.observeUiEntity().first()
            if (uiEntity == null) {
                Timber.d("Inserting RTDB data in Room")
                uiRepository.insertUiEntity(ui)
                dataStore.saveShouldUpdateDataBase(false)
            } else {
                Timber.d("Updating UI with RTDB data")
                uiRepository.updateUiEntity(ui)
                _uiState.value = ui
                dataStore.saveShouldUpdateDataBase(false)

            }
        }
    }

    private fun uiEntityListener(snapshot: DataSnapshot): UiEntity {

        val homeDataSnapshot = snapshot.child("home")
        val cartDataSnapshot = snapshot.child("menu")

        val homeCategoriesListData = homeDataSnapshot
            .child("categoriesList")
            .child("data")
            .children.mapNotNull { dataSnapshot ->
                typeSafeNestedDataClass(
                    receivedData = dataSnapshot.value,
                    defaultData = Category(),
                    nestedData = MenuItem(),
                )
            }

        val homeCategoriesList = CategoriesList(data = homeCategoriesListData)

        val homeUiConfiguration = typeSafeDataClass(
            receivedData = homeDataSnapshot.child("uiConfiguration").value,
            defaultData = CategoriesUiConfiguration()
        ).applyCorrections()

        val cartUiConfiguration = typeSafeDataClass(
            receivedData = cartDataSnapshot.child("uiConfiguration").value,
            defaultData = MenuUiConfiguration()
        ).applyCorrections()


        val homeScreen = CategoriesScreenData(
            uiConfiguration = homeUiConfiguration,
            categoriesList = homeCategoriesList
        )

        val cartScreen = MenuScreenData(
            uiConfiguration = cartUiConfiguration,
        )

        return UiEntity(homeScreen = homeScreen, cartScreen = cartScreen)
    }
}




