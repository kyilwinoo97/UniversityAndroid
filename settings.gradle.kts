pluginManagement {
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
        maven(url = "https://jitpack.io")

        
    }
}

rootProject.name = "UniversityAndroid"
include(":app")
include(":list_module")
include(":core")
include(":detail")
