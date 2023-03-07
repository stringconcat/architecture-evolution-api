plugins {
    id("org.jetbrains.kotlin.plugin.jpa")
}

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    implementation("javax.persistence:javax.persistence-api")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}