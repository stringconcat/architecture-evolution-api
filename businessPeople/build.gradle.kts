plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.injectApi)
    implementation(libs.bundles.kotlinxEcosystem)
    testImplementation(libs.bundles.unitTesting)
}