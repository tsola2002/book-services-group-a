# Runtime stage only - using your pre-built JAR
FROM eclipse-temurin:21-jre

WORKDIR /app
EXPOSE 8080

# Copy the specific JAR file from your host machine
COPY build/libs/reviewService-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]