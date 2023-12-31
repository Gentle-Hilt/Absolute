@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("gentle.hilt.library")
    id("gentle.hilt.compose.library")
}

android {
    namespace = "gentle.hilt.dependencies"
}

// Module for screenPlugin to easily setup dependencies in each screen
dependencies {
    // Core of every Screen
    api(libs.compose.activity)
    api(libs.compose.foundation)
    api(libs.compose.runtime)
    api(libs.constraint.compose)
    api(libs.compose.text)
    api(libs.compose.lifecycle)
    // Di
    api(libs.koin.android)
    api(libs.koin.compose)
}