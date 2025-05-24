## Étape 1 : compilation
#FROM maven:3.8.6-openjdk-11 AS builder
#WORKDIR /app
#
#COPY pom.xml .
#COPY src ./src
#
#RUN mvn clean package -DskipTests
#
## Étape 2 : image finale
#FROM openjdk:11-jdk-slim
#WORKDIR /app
#
#COPY --from=builder /app/target/app-0.0.1-SNAPSHOT.jar app.jar
#COPY wait-for-it.sh /wait-for-it.sh
#COPY start.sh /start.sh
#
#RUN chmod +x /wait-for-it.sh /start.sh
#
#EXPOSE 8081
#
#ENTRYPOINT ["/start.sh"]
#
#FROM openjdk:11-jdk-slim
#WORKDIR /app
#
#COPY target/app-0.0.1-SNAPSHOT.jar app.jar
#COPY wait-for-it.sh /wait-for-it.sh
#COPY start.sh /start.sh
#
#RUN chmod +x /wait-for-it.sh /start.sh
#
#EXPOSE 8081
#ENTRYPOINT ["/start.sh"]
##

# Étape 1 : image de base avec Java
FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY wait-for-it.sh /wait-for-it.sh
COPY start.sh /start.sh

RUN chmod +x /wait-for-it.sh /start.sh

EXPOSE 8081

ENTRYPOINT ["/start.sh"]
