@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("gentle.hilt.application")
    id("gentle.hilt.compose.application")
    alias(libs.plugins.ktlint)
}

android {
    namespace = "gentle.hilt.absolute"
    testOptions.unitTests.isIncludeAndroidResources = true
    defaultConfig {
        applicationId = "gentle.hilt.absolute"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(projects.serverDrivenUi)
    implementation(projects.navigation)
    implementation(projects.screens.menu)
    implementation(projects.screens.categories)
    implementation(projects.screens.cart)
    implementation(projects.screens.history)
    implementation(projects.screens.profile)

    implementation(libs.compose.activity)
    implementation(libs.compose.lifecycle)
    implementation(libs.gentle.hilt.navigation)
    implementation(libs.koin.android)
    implementation(libs.koin.workmanager)
    implementation(libs.lifecycle.process)
    implementation(libs.splash.screen)

    implementation(libs.logger)
    implementation(libs.timber)
    implementation(libs.compose.strings.lyricist)

    implementation(libs.accompanist.permissions)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.ui)
}
