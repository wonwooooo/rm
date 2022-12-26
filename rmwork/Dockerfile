FROM openjdk:8-jdk-alpine
VOLUME /tmp
CMD ["mvn", "package", "&&", "java", "-jar", "target/docker-0.0.1-SNAPSHOT.jar"]
ARG JAR_FILE=target/docker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} docker-springboot.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/docker-springboot.jar"]