import org.gradle.api.initialization.resolve.RepositoriesMode

include(":gridview")


include(":listview")


include(":radiobuttons")


include(":ejemploteclados")


include(":botones")


include(":interfazcontrolesbasicos")


include(":botonespersonalizados")


include(":layoutsconpadding")


include(":layouts")


include(":pendingintentandalarmmanager")


include(":pruebaintent")


include(":contadorciclodevida")


include(":pruebaactivity")


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
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Tema2App1"
include(":app")
include(":app:saludapp")
include(":tiradadosapp")

