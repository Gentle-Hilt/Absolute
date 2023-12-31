pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("testLibs") {
            from(files("../absolute/gradle/testLibs.versions.toml"))
        }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "Absolute"
include(":app")
include(":navigation")
include(":data")
include(":dependencies")
include(":server_driven_ui")
include(":screens:categories")
include(":screens:menu")
include(":screens:cart")
include(":screens:history")
include(":screens:profile")
