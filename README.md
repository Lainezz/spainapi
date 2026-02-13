# SpainAPI: Spanish Territorial Nomenclature Microservice

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0+-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-24.0+-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-8.0+-02303A?style=for-the-badge&logo=gradle&logoColor=white)

## Executive Summary

**SpainAPI** is a high-performance RESTful microservice architected to serve as the definitive source of truth for Spanish territorial administrative divisions (Provinces and Municipalities). 

Designed with **Hexagonal Architecture principles**, the system enforces a strict separation of concerns between the Interface Adapters (API Layer) and the Domain Core, ensuring long-term maintainability, testability, and technology agnosticism.

## 🏗 System Architecture

The project follows a modular monolithic structure managed by **Gradle**, ensuring clean boundaries and dependency management.

### Module Breakdown
*   **`spainapi-api` (Interface Adapter Layer)**: 
    *   Primary entry point for HTTP requests.
    *   Handles DTO mappings (`MapStruct`), Input Validation (`JSR-380`), and Global Exception Handling (`RFC 7807 ProblemDetail`).
    *   Implements the **Facade Pattern** to orchestrate calls to the domain service, decoupling the web layer from business logic.
*   **`spainapi-core` (Domain & Infrastructure Layer)**: 
    *   Encapsulates the business rules and persistence mechanisms.
    *   Implements **Generic Repository patterns** over standard JPA/Hibernate repositories.
    *   Database schema management via JPA entities.

### Technology Stack
*   **Language**: Java 17 (LTS)
*   **Framework**: Spring Boot 3 (Spring WebMVC, Spring Data JPA)
*   **Build Tool**: Gradle (Kotlin DSL)
*   **Persistence**: MySQL 8.0 (InnoDB engine)
*   **Observability Stack**: Prometheus (Metrics Export) + Grafana (Visualization)
*   **Containerization**: Docker & Docker Compose V2

## 🚀 Getting Started

### Prerequisites
*   Docker Desktop (with Docker Compose V2)
*   JDK 17+ (optional, for local non-Docker builds)

### Local Development Environment
The project includes a comprehensive `docker-compose.yml` to spin up the entire infrastructure stack (Database + Observability).

1.  **Start Infrastructure**:
    ```bash
    docker compose up -d
    ```
    *   MySQL Database: `localhost:3309`
    *   Prometheus: `http://localhost:9090`
    *   Grafana: `http://localhost:3000`

2.  **Run Application (Dev Profile)**:
    ```bash
    ./gradlew :spainapi-api:bootRun --args='--spring.profiles.active=dev'
    ```
    The application will start on **port 8080**.

3.  **Explore API Documentation (Swagger UI)**:
    Access the OpenAPI 3.0 interactive documentation at:
    *   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 📡 Observability & Monitoring

The system is instrumented with Micrometer to expose application metrics for Prometheus scraping.
*   **Prometheus Target**: `/actuator/prometheus` (Polled by the local Prometheus container).
*   **Grafana Dashboards**: Visualize JVM metrics, HTTP throughput, and latency.

> **Note for Production**: A specific Docker Compose configuration is required for the bare-metal deployment target (Raspberry Pi) to persistent storage for metrics.

## 🔄 CI/CD Pipelines

Automated workflows are defined via **GitHub Actions** to ensure code quality and seamless delivery.

| Workflow | Trigger | Description |
| :--- | :--- | :--- |
| **Feature Validation** | Push to `feature/*` | Executes Unit & Integration Tests (JUnit 5) to ensure non-regression. |
| **Release & Deploy** | Merge to `main` | Builds the Docker image, tags it with the semantic version, and pushes artifacts to Docker Hub for deployment to the edge device (Raspberry Pi). |

## 📦 Deployment (Raspberry Pi Target)

The production deployment on the edge device utilizes a dedicated compose file (`docker-compose.app.yml`).

```bash
# Pull the latest artifacts from the registry
sudo docker compose -f docker-compose.app.yml pull

# Zero-downtime deployment (Rolling Update)
sudo docker compose -f docker-compose.app.yml up -d
```
