plugins {
    kotlin("jvm")
    kotlin("plugin.jpa")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    implementation(libs.springBootStarterDataJpa)
    implementation(libs.springBootStarterValidation)

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}