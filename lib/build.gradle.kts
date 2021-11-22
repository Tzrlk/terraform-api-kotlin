#!/usr/bin/env gradle

plugins {
	id("com.google.protobuf")
	id("de.undercouch.download")
}

sourceSets {
	main {
		proto {
			srcDir("src/main/proto")
		}
	}
}

dependencies {
}

protobuf {
	protoc {
		artifact = "com.google.protobuf:protoc:3.12.0"
	}
	plugins {
		javalite {
			artifact = "com.google.protobuf:protoc-gen-javalite:3.0.0"
		}
		grpc {
			artifact = "io.grpc:protoc-gen-grpc-java:1.30.0"
		}
	}
	generateProtoTasks {
		all().each { task ->
			task.builtins {
				remove(javanano)
				java {
					option("lite")
				}
			}
			task.plugins {
				javalite {}
				grpc {
					option("lite")
				}
			}
		}
	}
}

tasks {

	named<Download>("fetch:proto:v5") {
		src("https://raw.githubusercontent.com/hashicorp/terraform-plugin-go/main/tfprotov5/internal/tfplugin5/tfplugin5.proto")
		dest(buildDir)
		onlyIfModified(true)
	}

	named<Download>("fetch:proto:v6") {
		src("https://raw.githubusercontent.com/hashicorp/terraform-plugin-go/main/tfprotov6/internal/tfplugin6/tfplugin6.proto")
		dest(buildDir)
		onlyIfModified(true)
	}

}
