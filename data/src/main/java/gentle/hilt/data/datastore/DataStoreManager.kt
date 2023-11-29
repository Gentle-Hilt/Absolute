package gentle.hilt.data.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore("datastore")

class DataStoreManager (
    context: Context
) {
    private val dataStore = context.dataStore

    private object PreferencesKeys {

    }


}
