plugins {
    id("org.springframework.boot") version "3.5.5" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
}


description = "API Spain"

allprojects {

    group = "com.es"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}
