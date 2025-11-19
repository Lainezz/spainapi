# Imagen de Java 17 compatible con Raspberry Pi (ARM)
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copiamos el JAR generado por Spring Boot
COPY spainapi-api/build/libs/spainapi-api-0.0.1-SNAPSHOT.jar app.jar

# Puerto interno donde escucha Spring Boot
EXPOSE 8080

# Opcional: variable para tunear la JVM
ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
