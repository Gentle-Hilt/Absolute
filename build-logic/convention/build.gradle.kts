import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "gentle.hilt.absolute.buildlogic"


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}


dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("Application") {
            id = "gentle.hilt.application"
            implementationClass = "ApplicationPlugin"
        }
        register("ApplicationCompose") {
            id = "gentle.hilt.compose.application"
            implementationClass = "ApplicationComposePlugin"
        }

        register("Library") {
            id = "gentle.hilt.library"
            implementationClass = "LibraryPlugin"
        }

        register("LibraryCompose"){
            id = "gentle.hilt.compose.library"
            implementationClass = "LibraryComposePlugin"
        }

        register("Screens"){
            id = "gentle.hilt.screens"
            implementationClass = "ScreensPlugin"
        }
    }
}
