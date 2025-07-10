plugins {
    kotlin("jvm")
}

dependencies {
    implementation("javax.inject:javax.inject:1")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}