plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.injectApi)

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}