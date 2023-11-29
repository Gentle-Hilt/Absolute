package gentle.hilt.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.TOP_APP_BAR_TITLE
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.UI_UPDATES_TRIGGER
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_AUTO
import gentle.hilt.data.datastore.MagicNumbers.DEFAULT_THEME
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("datastore")

class DataStoreManager (
    context: Context
) {
    private val dataStore = context.dataStore

    private object PreferencesKeys {
        val UI_UPDATES_TRIGGER = booleanPreferencesKey("UI_UPDATES_TRIGGER")
        val TOP_APP_BAR_TITLE = stringPreferencesKey("TOP_APP_BAR_TITLE")
        val THEME_PICKER = intPreferencesKey("THEME_PICKER")
        val DARK_MODE = intPreferencesKey("DARK_MODE")
    }

    suspend fun saveShouldUpdateDataBase(trigger: Boolean) = dataStore.edit { preferences ->
        preferences[UI_UPDATES_TRIGGER] = trigger
    }

    val readShouldUpdateDataBase: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[UI_UPDATES_TRIGGER] ?: true
    }

    suspend fun saveCurrentTopBarTitle(category: String) = dataStore.edit { preferences ->
        preferences[TOP_APP_BAR_TITLE] = category
    }

    @OptIn(FlowPreview::class)
    val readCurrentTopBarTitle: Flow<String> = dataStore.data.debounce(150).map { preferences ->
        preferences[TOP_APP_BAR_TITLE] ?: "Home"
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
