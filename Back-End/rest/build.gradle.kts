apply {
    plugin("kotlin-spring")
    plugin("org.springframework.boot")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":persistence-adapter"))
    implementation("org.springdoc:springdoc-openapi-ui:1.5.11")

    implementation("org.springframework.boot:spring-boot-starter-validation:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}