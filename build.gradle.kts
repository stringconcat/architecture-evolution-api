import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.8"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.10"
	kotlin("plugin.spring") version "1.8.10"
	id("org.jetbrains.kotlin.plugin.jpa") version "1.8.10"
}

group = "com.thoughtworks"
version = "0.0.1-SNAPSHOT"


repositories {
	mavenCentral()
}

dependencies {
	// spring modules
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	// kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// tools
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// view
	implementation("org.springdoc:springdoc-openapi-ui:1.6.13")
	implementation("org.springdoc:springdoc-openapi-data-rest:1.6.13")

	//persistance
	runtimeOnly("com.h2database:h2")
	implementation("javax.persistence:javax.persistence-api:2.2")

	// tests
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
	}
}
