pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS) // Change to this
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AlDamegh_AlThumairy"
include(":app")
include(":OpenCV")
