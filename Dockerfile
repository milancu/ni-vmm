FROM maven:3.8.3-openjdk-17 AS builder

WORKDIR /app
COPY . .

RUN mvn clean package

FROM openjdk:17-jdk-slim
LABEL authors="milancu"

WORKDIR /app

COPY target/project-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]