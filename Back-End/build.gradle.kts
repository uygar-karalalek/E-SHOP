plugins {
    id("org.springframework.boot") version "2.5.5" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false

    kotlin("plugin.spring") version "1.5.31" apply false
    kotlin("plugin.jpa") version "1.5.31" apply false
    kotlin("plugin.allopen") version "1.5.31"
    kotlin("jvm") version "1.5.31"
    kotlin("kapt") version "1.5.31"
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://plugins.gradle.org/m2/") }
}

subprojects {

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }

    apply {
        plugin("java")
        plugin("kotlin")
        plugin("io.spring.dependency-management")
        plugin("kotlin-kapt")
        plugin("kotlin-allopen")
    }

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    dependencies {
// https://mvnrepository.com/artifact/org.springframework/spring-context
        implementation("org.springframework:spring-context:5.3.14")
        implementation(kotlin("reflect"))
        implementation(kotlin("stdlib-jdk8"))
        kapt("org.springframework.boot:spring-boot-configuration-processor")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
            exclude(module = "mockito-core")
        }
    }

    group = "com.uygar.eshop"
    version = "1.0-SNAPSHOT"

}