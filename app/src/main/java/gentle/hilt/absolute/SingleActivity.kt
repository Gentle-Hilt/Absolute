package gentle.hilt.absolute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import gentle.hilt.absolute.theme_selector.ProvideThemes
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.strings.LocalStrings
import gentle.hilt.data.res.strings.allLocales
import org.koin.android.ext.android.inject

class SingleActivity : ComponentActivity() {
    
    private val dataStore: DataStoreManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProvideThemes(dataStore) {
                ProvideStrings(lyricist = rememberStrings(allLocales), provider = LocalStrings) {

                }
            }
        }
    }


}

