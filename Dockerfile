
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/payment-verification-system-websocket.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]