FROM openjdk:23-bookworm

WORKDIR /app

COPY . .

RUN chmod +x gradlew && ./gradlew clean bootJar --no-daemon -x test

CMD ["java", "-jar", "build/libs/your-app.jar"]
