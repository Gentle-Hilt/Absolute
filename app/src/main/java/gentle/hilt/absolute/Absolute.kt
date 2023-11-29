package gentle.hilt.absolute

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import gentle.hilt.absolute.di.absoluteModule
import gentle.hilt.categories.categoriesScreen
import gentle.hilt.menu.menuScreen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class Absolute : Application() {

    override fun onCreate() {
        super.onCreate()
        clickableTimberLogs()

        ScreenRegistry {
            categoriesScreen()
            menuScreen()
        }

        startKoin {
            androidLogger()
            androidContext(this@Absolute)
            workManagerFactory()
            modules(absoluteModule)
        }
    }
}

private const val TIMBER_WILL_JUMP_TO_MESSAGE_FROM_LOGCAT = 4

fun clickableTimberLogs() {
    val formatStrategy: FormatStrategy = PrettyFormatStrategy
        .newBuilder()
        .tag("")
        .methodCount(1)
        .methodOffset(TIMBER_WILL_JUMP_TO_MESSAGE_FROM_LOGCAT)
        .build()
    Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    Timber.plant(object : Timber.DebugTree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            Logger.log(priority, "-$tag", message, t)
        }
    })
}
