plugins {
    kotlin("jvm")
    kotlin("plugin.jpa")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.springBootStarterDataJpa)
    implementation(libs.springBootStarterValidation)
    testImplementation(libs.bundles.unitTesting)
}