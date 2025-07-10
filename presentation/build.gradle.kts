plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    // spring modules
    implementation(libs.springBootStarterWeb)

    // tools
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation(libs.springBootStarterTest)
}