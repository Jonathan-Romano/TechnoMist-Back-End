FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/ventas-Technomist-0.0.1.jar
COPY ${JAR_FILE} app_sell.jar
ENTRYPOINT ["java","-jar","app_sell.jar"]