plugins {
    kotlin("jvm") version "1.5.31"
}

repositories {
    mavenCentral()
}

subprojects {

    repositories {
        mavenCentral()
    }

    apply {
        plugin("java")
        plugin("kotlin")
    }
    dependencies {
        implementation(kotlin("stdlib-jdk8"))
    }

    group = "org.example"
    version = "1.0-SNAPSHOT"

}