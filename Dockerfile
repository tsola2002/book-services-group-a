# Build stage
FROM eclipse-temurin:23 AS builder

WORKDIR /app
COPY build/libs/*.jar .

# Final stage
FROM eclipse-temurin:23-jre

WORKDIR /app
COPY --from=builder /app/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]