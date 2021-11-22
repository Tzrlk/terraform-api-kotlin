#!/usr/bin/env gradle

plugins {
	id("org.jetbrains.kotlin.multiplatform")
	id("org.linguica.maven-settings")
	id("org.jetbrains.gradle.plugin.idea-ext")
	idea
}

allprojects {
	val kotlinVersion: String by project
	val spekVersion: String by project
	val protobufVersion: String by project

	tasks {

		named<Test>("test") {
			useJUnitPlatform {
				includeEngines("spek2")
			}
		}

	}

	dependencies {

		// Kotlin
		implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"))
		implementation("org.jetbrains.kotlin:kotlin-stdlib")
		testImplementation("org.jetbrains.kotlin:kotlin-test")
		testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect")

		// Spek2
		testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
		testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")

	}

	kotlin {
		jvm()
		linuxX64()
		macosX64()
		mingwX64()
	}

}
