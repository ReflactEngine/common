plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm")
}

group = "net.reflact"
version = "2026.01.08-1.21.11"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.google.code.gson:gson:2.11.0")
    // Use netty-buffer for packet serialization helpers if needed, provided by both environments
    compileOnly("io.netty:netty-buffer:4.1.97.Final") 
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_25)
    }
}
