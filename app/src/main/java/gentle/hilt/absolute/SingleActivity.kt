package gentle.hilt.absolute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import gentle.hilt.data.datastore.DataStoreManager
import org.koin.android.ext.android.inject

class SingleActivity : ComponentActivity() {

    private val dataStore: DataStoreManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

        }
    }


}

