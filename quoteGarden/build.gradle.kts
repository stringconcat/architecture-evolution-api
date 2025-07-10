plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))

    implementation(libs.injectApi)
    implementation(libs.springBootStarterWeb)


    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}