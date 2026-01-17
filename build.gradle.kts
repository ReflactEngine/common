plugins {
    `java-library`
    `maven-publish`
}

group = "net.reflact"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    // Use netty-buffer for packet serialization helpers if needed, provided by both environments
    compileOnly("io.netty:netty-buffer:4.1.97.Final") 
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}
