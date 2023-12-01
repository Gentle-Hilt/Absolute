package gentle.hilt.absolute

import android.app.Application
import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.work.WorkerParameters
import com.google.common.truth.Truth.assertThat
import com.google.firebase.FirebaseApp
import gentle.hilt.absolute.di.absoluteModule
import gentle.hilt.data.cart.CartRepository
import gentle.hilt.data.datastore.DataStoreManager
import gentle.hilt.data.server_driven_ui.UiRepository
import gentle.hilt.server_driven_ui.SharedUiViewModel
import gentle.hilt.server_driven_ui.worker.UpdateDataBaseWorker
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.check.checkModules
import org.koin.test.get
import org.koin.test.verify.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = Application::class, manifest = Config.NONE)
class KoinMimickingCompileTypeSafety : KoinTest {
    private val context = RuntimeEnvironment.getApplication().applicationContext

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(absoluteModuleTest)
    }

    private val absoluteModuleTest = module {
        single { mockk<WorkerParameters>(relaxed = true) }
        worker { UpdateDataBaseWorker(appContext = get(), workerParams = get()) }

        single { mockk<UiRepository>(relaxed = true) }
        single { mockk<CartRepository>(relaxed = true) }
        single { mockk<DataStoreManager>(relaxed = true) }
        single { SharedUiViewModel(uiRepository = get(), cartRepository = get(), dataStore = get()) }
    }

    @Before
    fun setup() {
        // Firebase Shenanigans
        mockkStatic(FirebaseApp::class)
        mockkConstructor(FirebaseApp::class)
        every { anyConstructed<FirebaseApp>().options } returns mockk()
        every { anyConstructed<FirebaseApp>().options.applicationId } returns context.packageName
        every { anyConstructed<FirebaseApp>().options.databaseUrl } returns "https://mocked-database-url.firebaseio.com/"
        every { anyConstructed<FirebaseApp>().options.apiKey } returns "api_key"
        FirebaseApp.initializeApp(context)
        every { FirebaseApp.initializeApp(any()) } returns mockk()
    }

    @After
    fun after() {
        unmockkStatic(FirebaseApp::class)
    }

    @Test
    fun `Dynamic koin modules check`() {
        koinApplication {
            allowOverride(true)
            androidContext(context)
            modules(absoluteModule, absoluteModuleTest)
            checkModules()
        }
    }

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun `Verifying modules integrity`() {
        absoluteModule.verify(
            extraTypes = listOf(
                com.google.firebase.FirebaseApp::class,
                com.google.firebase.inject.Provider::class,
                java.util.concurrent.Executor::class,
                java.util.concurrent.ScheduledExecutorService::class,
                Context::class,
                SavedStateHandle::class,
                WorkerParameters::class
            )
        )
    }

    @Test
    fun `SharedUiViewModel dependencies verification`() {
        val expectedUiRepository = get<UiRepository>()
        val expectedCartRepository = get<CartRepository>()
        val expectedDataStore = get<DataStoreManager>()

        val sharedUiViewModel: SharedUiViewModel = get()

        val (actualUiRepository, actualCartRepository, actualDataStore) = sharedUiViewModel.dependenciesTestOnly()

        assertThat(sharedUiViewModel).isNotNull()
        assertThat(expectedUiRepository).isEqualTo(actualUiRepository)
        assertThat(expectedCartRepository).isEqualTo(actualCartRepository)
        assertThat(expectedDataStore).isEqualTo(actualDataStore)
    }
}
