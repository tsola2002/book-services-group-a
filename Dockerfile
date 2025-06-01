FROM eclipse-temurin:23

WORKDIR /app
COPY . .

# Give permission to run gradlew
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build -x test

# Use a smaller runtime image
FROM eclipse-temurin:23-jre

WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=0 /app/build/libs/*.jar app.jar

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
