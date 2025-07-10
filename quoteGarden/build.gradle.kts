plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))

    implementation("javax.inject:javax.inject:1")
    implementation(libs.springBootStarterWeb)


    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}