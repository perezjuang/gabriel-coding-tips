FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="perezjuang@hotmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8189

ARG JAR_FILE=/demojgpback/target/demoBack-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app

# cp target/demoBack-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

# Run the jar file 
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demoBack-0.0.1-SNAPSHOT.jar"]