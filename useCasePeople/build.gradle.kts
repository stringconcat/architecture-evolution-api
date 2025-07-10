plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))

    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.injectApi)
    testImplementation(libs.bundles.unitTesting)
}