rootProject.name = "terraform-api-kotlin"

include("lib")

pluginManagement {
	val kotlinVersion: String by settings
	val protobufVersion: String by settings
	repositories {
		gradlePluginPortal()
	}
	plugins {
		id("org.jetbrains.kotlin.multiplatform") version kotlinVersion
		id("net.linguica.maven-settings") version "0.5"
		id("de.undercouch.download") version "4.1.2"
		id("com.google.protobuf") version protobufVersion
		id("org.jetbrains.gradle.plugin.idea-ext") version "1.3.0"
	}
}

dependencyResolutionManagement {
	repositories {
		mavenCentral()
	}
}
