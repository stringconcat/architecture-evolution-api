plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(libs.injectApi)
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}