package gentle.hilt.menu


import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.server_driven_ui.categories.Category
import gentle.hilt.menu.screen.Menu
import gentle.hilt.menu.screen.MenuScreenLifeCycle
import gentle.hilt.menu.screen.TagsBar
import gentle.hilt.menu.screen.server_driven_ui.extractFilteredMenuItems
import gentle.hilt.menu.screen.server_driven_ui.extractListType
import gentle.hilt.menu.screen.server_driven_ui.extractMenuItems
import gentle.hilt.menu.screen.server_driven_ui.extractTagsList
import gentle.hilt.menu.screen.server_driven_ui.extractUiConfiguration
import gentle.hilt.server_driven_ui.SharedUiViewModel
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.koin.androidx.compose.getViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


@Parcelize
data class MenuScreen(val category: Category) : Screen, Parcelable, KoinComponent {

    @IgnoredOnParcel
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel: SharedUiViewModel = getViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val dataStore: DataStoreManager by inject()
        MenuScreenLifeCycle(Screen = this@MenuScreen, category = category, dataStore = dataStore)

        uiState?.let { uiEntity->
            val menuItems = extractMenuItems(uiEntity, category)
            var selectedTags by remember { mutableStateOf<List<String>>(emptyList()) }
            val filteredMenuItems = extractFilteredMenuItems(selectedTags, menuItems)
            val uiConfiguration = extractUiConfiguration(uiEntity)
            val listType = extractListType(uiConfiguration)
            val tagsList = extractTagsList(menuItems)

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.themeColors.background)
            ) {
                val (menu, tags) = createRefs()

                Menu(
                    filteredMenuItems,
                    uiConfiguration,
                    listType,
                    modifier = Modifier.constrainAs(menu) {
                        top.linkTo(tags.bottom)
                        centerHorizontallyTo(parent)
                        bottom.linkTo(parent.bottom)

                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    }
                )

                TagsBar(
                    tagsList,
                    selectedTags,
                    modifier = Modifier.constrainAs(tags) {
                        top.linkTo(parent.top)
                        centerHorizontallyTo(parent)
                        bottom.linkTo(menu.top)

                        height = Dimension.wrapContent
                        width = Dimension.fillToConstraints
                    }) { newTags ->
                    selectedTags = newTags
                }
            }

        }
    }
}






