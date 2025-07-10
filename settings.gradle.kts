dependencyResolutionManagement {
    // Use Maven Central as the default repository (where Gradle will download dependencies) in all subprojects.
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

plugins {
    // Use the Foojay Toolchains plugin to automatically download JDKs required by subprojects.
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "kotlin-quarkus-template"

// Enable the Typesafe Project Accessors feature, which allows you to access subprojects using a type-safe API.
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "people"
include(":businessPeople")
include(":presentation")
include(":useCasePeople")
include(":persistence")
include(":quoteGarden")
include(":avatarsDicebear")
include(":application")