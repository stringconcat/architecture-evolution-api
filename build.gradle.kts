
plugins {
//	id("buildsrc.convention.kotlin-jvm")
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25" apply false
	id("org.springframework.boot") version "3.5.3" apply false
	kotlin("plugin.jpa") version "1.9.25" apply false
}

group = "com.thoughtworks"
version = "0.0.1-SNAPSHOT"


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

allprojects {
//	apply {
//		plugin("buildsrc.convention.kotlin-jvm")
//	}

	repositories {
		gradlePluginPortal()
		mavenCentral()
	}
}


repositories {
	mavenCentral()
}

dependencies {

	implementation(project(":application"))
	implementation(libs.springBootStarter)
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation(libs.springBootStarterWeb)
	implementation(libs.springBootStarterDataJpa)
	implementation(libs.springBootStarterValidation)


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	runtimeOnly("com.h2database:h2:2.2.224")

}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
