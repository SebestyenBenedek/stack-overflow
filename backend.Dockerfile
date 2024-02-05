FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY target/stackoverflow-tw-0.0.1-SNAPSHOT.jar /app.jar
COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh