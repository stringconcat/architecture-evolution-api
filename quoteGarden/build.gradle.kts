plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))

    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.injectApi)
    implementation(libs.springBootStarterWeb)
    testImplementation(libs.bundles.unitTesting)
}