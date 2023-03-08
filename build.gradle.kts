
plugins {
	id("org.springframework.boot") version "2.7.8" apply false
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21" apply false
	id("org.jetbrains.kotlin.plugin.jpa") version "1.6.21" apply false
}

allprojects {
	group = "com.thoughtworks"
	version = "0.0.1-SNAPSHOT"


	apply {
		plugin("io.spring.dependency-management")
		plugin("org.jetbrains.kotlin.jvm")
	}


	repositories {
		mavenCentral()
		jcenter()
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.boot:spring-boot-dependencies:2.7.8")
		}
		dependencies {
			// kotlin
			dependency("org.jetbrains.kotlin:kotlin-reflect:1.8.10")

			// tests
			dependency("org.junit.jupiter:junit-jupiter-api:5.9.2")
			dependency("io.mockk:mockk:1.9.3")
		}
	}

	dependencies {

	}

	tasks {
		withType<Test> {
			useJUnitPlatform()
		}
	}
}


dependencies {
	implementation(project(":application"))

	//persistance
	runtimeOnly("com.h2database:h2")
}



