plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    java
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

dependencies {
    // Depende del core
    implementation(project(":spainapi-core"))

    // Starters de Spring (bundle del version catalog)
    implementation(libs.bundles.spring.boot.starters)

    // Otros
    implementation(libs.modelmapper)
    implementation(libs.micrometer.registry.prometheus)

    // SWAGGER
    implementation(libs.springdoc.openapi.ui)

    // Annotation processors (Spring config + Lombok)
    annotationProcessor(libs.spring.boot.configuration.processor)
    annotationProcessor(libs.lombok)

    // Lombok solo en compilación
    compileOnly(libs.lombok)

    // Solo en desarrollo
    developmentOnly(libs.spring.boot.devtools)

    // Solo en tiempo de ejecución
    runtimeOnly(libs.mysql.driver)

    // Tests
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.spring.boot.starter.test)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// Marca explícitamente la clase main
springBoot {
    mainClass.set("com.es.spainapi.SpainapiApplication")
}
