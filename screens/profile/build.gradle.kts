@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("gentle.hilt.screens")
}

android {
    namespace = "gentle.hilt.profile"
}

dependencies {
    implementation(libs.firebase.ui)
}