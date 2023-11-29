package gentle.hilt.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import gentle.hilt.data.datastore.MagicNumbers.DARK_MODE_AUTO
import gentle.hilt.data.datastore.MagicNumbers.DEFAULT_THEME
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.DARK_MODE
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.FIRST_TIME_IN_APP
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.SILENT_NOTIFICATIONS
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.THEME_PICKER
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.TOP_APP_BAR_TITLE
import gentle.hilt.data.datastore.DataStoreManager.PreferencesKeys.UI_UPDATES_TRIGGER
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
        val SILENT_NOTIFICATIONS = booleanPreferencesKey("SILENT_NOTIFICATIONS")
        val FIRST_TIME_IN_APP = booleanPreferencesKey("FIRST_TIME_IN_APP")
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


    suspend fun saveShouldTurnSilentUpdates(trigger: Boolean) = dataStore.edit{ preferences->
        preferences[SILENT_NOTIFICATIONS] = trigger
    }

    val readSilentUpdates: Flow<Boolean> = dataStore.data.map { preferences->
        preferences[SILENT_NOTIFICATIONS] ?: false
    }

    suspend fun saveFirstTimeInApp(firstTime: Boolean) = dataStore.edit { preferences ->
        preferences[FIRST_TIME_IN_APP] = firstTime
    }

    val readFirstTimeInApp: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[FIRST_TIME_IN_APP] ?: true
    }

    suspend fun saveTheme(theme:Int) = dataStore.edit { preferences->
        preferences[THEME_PICKER] = theme
    }

    val readTheme: Flow<Int> = dataStore.data.map { preferences->
        preferences[THEME_PICKER] ?: DEFAULT_THEME
    }

    suspend fun saveDarkMode(darkMode:Int) = dataStore.edit{ preferences->
        preferences[DARK_MODE] = darkMode
    }

    val readDarkMode:Flow<Int> = dataStore.data.map { preferences->
        preferences[DARK_MODE] ?: DARK_MODE_AUTO
    }
}
