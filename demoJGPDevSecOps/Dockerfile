# For Java 8, try this
FROM openjdk:8-jdk-alpine
#FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/demoJJMR-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app

# cp target/demoJJMR-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]