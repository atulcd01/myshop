FROM openjdk:8-alpine
ARG JAR_FILE=target/shopinstaller*.jar
COPY target/shopinstaller*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]