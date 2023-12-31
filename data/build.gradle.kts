@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("gentle.hilt.library")
    alias(libs.plugins.ksp)
    id("gentle.hilt.compose.library")
}

android {
    namespace = "gentle.hilt.data"

    defaultConfig{
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {
    ksp(libs.room.compiler)

    implementation(libs.koin.android)
    implementation(libs.room.runtime)
    implementation(libs.room)
    implementation(libs.gson)
    implementation(libs.firebase.database)
    implementation(libs.firebase.ui)
    implementation(libs.kotlin.reflect)
    implementation(libs.compose.strings.lyricist)
    
    // Util
    debugApi(libs.compose.ui.preview)
    debugApi(libs.compose.ui.tooling)

    // Entire application see those dependencies because of ScreensPlugin in build-logic
    api(libs.logger)
    api(libs.timber)
    api(libs.compose.coil)
    api(libs.datastore.preferences)
    api(libs.compose.ui)
    api(libs.compose.material)
}