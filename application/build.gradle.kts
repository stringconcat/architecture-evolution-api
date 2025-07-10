plugins {
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.3"
    kotlin("plugin.jpa") version "1.9.25"
}


dependencies {
    implementation(project(":presentation"))
    implementation(project(":persistence"))
    implementation(project(":useCasePeople"))
    implementation(project(":businessPeople"))
    implementation(project(":quoteGarden"))
    implementation(project(":avatarsDicebear"))

    implementation(libs.springBootStarterWeb)
    implementation(libs.springBootStarterDataJpa)
    runtimeOnly(libs.h2Database)
    testImplementation(libs.bundles.unitTesting)
    testImplementation(libs.springBootStarterTest)
}