# Étape 1 : compilation
FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Étape 2 : image finale
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar
COPY wait-for-it.sh /wait-for-it.sh
COPY start.sh /start.sh
COPY src/main/resources/templates /templates

# Ensure scripts are executable and use LF line endings
RUN chmod +x /wait-for-it.sh /start.sh && \
    sed -i 's/\r$//' /start.sh && \
    sed -i 's/\r$//' /wait-for-it.sh

EXPOSE 8081

ENTRYPOINT ["sh", "/start.sh"]
