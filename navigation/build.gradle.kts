@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("gentle.hilt.library")
}

android {
    namespace = "gentle.hilt.navigation"
}

dependencies {
    implementation(projects.data)

    api(libs.gentle.hilt.navigation)
    api(libs.gentle.hilt.navigation.tab)
    api(libs.gentle.hilt.navigation.animation)
}