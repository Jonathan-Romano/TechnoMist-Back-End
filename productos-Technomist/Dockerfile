FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/productos-Technomist-0.0.1.jar
COPY ${JAR_FILE} app_prodcuts.jar
ENTRYPOINT ["java","-jar","app_prodcuts.jar"]