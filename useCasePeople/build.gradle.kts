plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))

    implementation(libs.injectApi)
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation(libs.bundles.unitTesting)
}