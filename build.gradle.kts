plugins {
    java
    id("org.springframework.boot") version "3.5.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.es"
version = "0.0.1-SNAPSHOT"
description = "API Spain"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    // Starters de Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Otros
    implementation("org.mapstruct:mapstruct:1.6.3")
    implementation("io.micrometer:micrometer-registry-prometheus")

    // SWAGGER
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.14")

    // Annotation processors (Spring config + Lombok + MapStruct)
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    // Lombok solo en compilación
    compileOnly("org.projectlombok:lombok:1.18.38")

    // Solo en desarrollo
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // Solo en tiempo de ejecución
    runtimeOnly("com.mysql:mysql-connector-j")

    // Tests
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// Marca explícitamente la clase main
springBoot {
    mainClass.set("com.es.spainapi.SpainapiApplication")
}
