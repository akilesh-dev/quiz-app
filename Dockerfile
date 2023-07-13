FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache maven

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

CMD ["java", "-jar", "quiz-app.jar"]

