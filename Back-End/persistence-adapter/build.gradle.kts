apply {
    plugin("kotlin-jpa")
}

dependencies {
    implementation(project(":core"))
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("ch.qos.logback:logback-classic:1.2.6")
    implementation("ch.qos.logback:logback-core:1.2.6")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.0")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.6")
    implementation("mysql:mysql-connector-java:8.0.27")

    testImplementation("com.ninja-squad:springmockk:3.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
}
