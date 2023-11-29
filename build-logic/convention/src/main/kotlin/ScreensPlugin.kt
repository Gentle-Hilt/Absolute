import com.android.build.api.dsl.LibraryExtension
import gentle.hilt.absolute.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ScreensPlugin: Plugin<Project>{

    override fun apply(target: Project) {
        with(target){

            pluginManager.apply{
                apply("gentle.hilt.library")
            }

            extensions.configure<LibraryExtension>{

                configureAndroidCompose(this)

                defaultConfig{
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            dependencies{
                add("implementation", project(":dependencies"))
                add("implementation", project(":navigation"))
                add("implementation", project(":server_driven_ui"))

            }
        }
    }
}