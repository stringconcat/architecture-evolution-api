plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(libs.injectApi)
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation(libs.bundles.unitTesting)
}