# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy project files
COPY . .

# Build the project and package the Spring Boot application
RUN mvn clean package -DskipTests -Dmaven.compiler.release=17

# Stage 2: Runtime
FROM eclipse-temurin:17

# Set working directory inside the container
WORKDIR /app

# Expose your application's port
EXPOSE 8081

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]