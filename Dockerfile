FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY BusSystem.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]