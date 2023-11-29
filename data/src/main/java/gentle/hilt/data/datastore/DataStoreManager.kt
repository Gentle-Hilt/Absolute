package gentle.hilt.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.UI_UPDATES_TRIGGER
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_AUTO
import gentle.hilt.data.datastore.MagicNumbers.DEFAULT_THEME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("datastore")

class DataStoreManager (
    context: Context
) {
    private val dataStore = context.dataStore

    private object PreferencesKeys {
        val UI_UPDATES_TRIGGER = booleanPreferencesKey("UI_UPDATES_TRIGGER")
        val THEME_PICKER = intPreferencesKey("THEME_PICKER")
        val DARK_MODE = intPreferencesKey("DARK_MODE")
    }

    suspend fun saveShouldUpdateDataBase(trigger: Boolean) = dataStore.edit { preferences ->
        preferences[UI_UPDATES_TRIGGER] = trigger
    }

    val readShouldUpdateDataBase: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[UI_UPDATES_TRIGGER] ?: true
    }

    suspend fun saveTheme(theme:Int) = dataStore.edit { preferences->
        preferences[PreferencesKeys.THEME_PICKER] = theme
    }

    val readTheme: Flow<Int> = dataStore.data.map { preferences->
        preferences[PreferencesKeys.THEME_PICKER] ?: DEFAULT_THEME
    }

    suspend fun saveDarkMode(darkMode:Int) = dataStore.edit{ preferences->
        preferences[PreferencesKeys.DARK_MODE] = darkMode
    }

    val readDarkMode:Flow<Int> = dataStore.data.map { preferences->
        preferences[PreferencesKeys.DARK_MODE] ?: DARK_MODE_AUTO
    }
}
