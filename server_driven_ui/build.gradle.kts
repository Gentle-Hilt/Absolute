@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("gentle.hilt.library")
    alias(libs.plugins.google.services)
}

android {
    namespace = "gentle.hilt.server_driven_ui"
}

dependencies {
    api(projects.data)

    implementation(libs.firebase.messaging)
    implementation(libs.firebase.database)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.kotlin.reflect)
    implementation(libs.koin.android)
    implementation(libs.koin.workmanager)
    implementation(libs.timber)
}