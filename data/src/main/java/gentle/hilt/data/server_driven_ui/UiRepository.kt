package gentle.hilt.data.server_driven_ui

import kotlinx.coroutines.flow.Flow

class UiRepository(
    val uiDao: UiDao,
) {

    suspend fun insertUiEntity(ui: UiEntity) {
        uiDao.insertUiEntity(ui)
    }

    suspend fun updateUiEntity(ui: UiEntity) {
        uiDao.updateEntity(ui)
    }

    suspend fun deleteUiEntity() {
        uiDao.deleteUnEntity()
    }

    fun observeUiEntity(): Flow<UiEntity?> = uiDao.observeUi()


}
