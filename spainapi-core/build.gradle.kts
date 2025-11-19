plugins {
    `java-library`
    id("io.spring.dependency-management")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

// Si tienes la versión de Spring Boot en el catalog como versions.spring.boot
dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.5")
        // o con el catalog:
        // mavenBom("org.springframework.boot:spring-boot-dependencies:${libs.versions.spring.boot.get()}")
    }
}

dependencies {
    // Core: JPA para entidades/repos/servicios
    implementation(libs.spring.boot.starter.data.jpa)

    // Lombok en core (si lo usas en entidades o servicios)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    // Tests
    testImplementation(libs.spring.boot.starter.test)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
