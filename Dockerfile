FROM eclipse-temurin:17-jdk-alpine AS build
RUN apk add --no-cache maven
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests
#CMD ["java", "-jar", "quiz-app.jar"]

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/quiz-app-1.0.0.jar .
EXPOSE 8080
CMD ["java", "-Dspring.profiles.active=dev", "-jar", "quiz-app-1.0.0.jar"]
