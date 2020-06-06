FROM openjdk:8-jdk-alpine
EXPOSE 8189
ARG JAR_FILE=/demojgpback/target/demoBack-0.0.1-SNAPSHOT-jar-with-dependencies.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]