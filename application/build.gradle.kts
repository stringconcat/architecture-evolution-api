plugins {
    kotlin("jvm") version "1.9.25"
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
    implementation("com.h2database:h2:2.3.232")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation(libs.springBootStarterTest)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}