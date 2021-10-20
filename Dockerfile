#FROM openjdk:8-jdk-alpine
#EXPOSE 8189
#ARG JAR_FILE=/demojgpback/target/demoBack-0.0.1-SNAPSHOT-jar-with-dependencies.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]



#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


FROM java:8-jdk-alpine
EXPOSE 8189
ARG JAR_FILE=/demojgpback/target/demoBack-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


#FROM openjdk:11
#COPY . /usr/src/myapp
#WORKDIR /usr/src/myapp
#RUN javac Main.java
#CMD ["java", "Main"]
#You can then run and build the Docker image:

#$ docker build -t my-java-app .
#$ docker run -it --rm --name my-running-app my-java-app







#FROM openjdk:11
#COPY . /usr/src/myapp
#WORKDIR /usr/src/myapp
#RUN javac Hello.java
#CMD ["java", "Hello"]
#docker build -t img-java-example .
#docker run -it --rm img-java-example