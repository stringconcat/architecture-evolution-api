plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    // spring modules
    implementation(libs.springBootStarterWeb)

    // tools
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation(libs.bundles.unitTesting)
    testImplementation(libs.springBootStarterTest)
}