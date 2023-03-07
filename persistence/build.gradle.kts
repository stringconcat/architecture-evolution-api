plugins {
    kotlin("jvm")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.jpa")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    implementation("javax.persistence:javax.persistence-api")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}