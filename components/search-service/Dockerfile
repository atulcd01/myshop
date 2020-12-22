FROM openjdk:8-alpine
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]