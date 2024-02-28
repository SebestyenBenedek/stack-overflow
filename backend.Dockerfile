FROM openjdk:17-jdk-alpine

WORKDIR /backend

ARG JAR_FILE=target/*.jar

COPY $JAR_FILE /backend/
COPY entrypoint.sh /backend/

RUN chmod +x /backend/entrypoint.sh

CMD ["java", "-jar", "target/stackoverflow-rw-0.0.1-SNAPSHOT.jar"]