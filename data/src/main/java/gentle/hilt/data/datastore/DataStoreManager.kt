package gentle.hilt.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.UI_UPDATES_TRIGGER
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("datastore")

class DataStoreManager (
    context: Context
) {
    private val dataStore = context.dataStore

    private object PreferencesKeys {
        val UI_UPDATES_TRIGGER = booleanPreferencesKey("UI_UPDATES_TRIGGER")
    }

    suspend fun saveShouldUpdateDataBase(trigger: Boolean) = dataStore.edit { preferences ->
        preferences[UI_UPDATES_TRIGGER] = trigger
    }

    val readShouldUpdateDataBase: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[UI_UPDATES_TRIGGER] ?: true
    }
}
