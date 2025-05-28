FROM eclipse-temurin:23 AS build

WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon -x test

FROM eclipse-temurin:23
WORKDIR /app
EXPOSE 8080

COPY --from=build /app/build/libs/*.jar app.jar
#COPY ca.pem /app/ca.pem
ENTRYPOINT ["java", "-jar", "app.jar"]

