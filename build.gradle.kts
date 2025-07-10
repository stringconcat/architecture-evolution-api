plugins {
	id("buildsrc.convention.kotlin-jvm")
	id("java")
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

	apply {
		plugin("buildsrc.convention.kotlin-jvm")
	}

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

	testImplementation(libs.bundles.unitTesting)

}

tasks.withType<Test> {
	useJUnitPlatform()
}
