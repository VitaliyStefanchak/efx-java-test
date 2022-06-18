FROM openjdk:17-alpine
EXPOSE 8080
COPY ./target/producer-0.0.1.jar /tmp/
WORKDIR /tmp
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "producer-0.0.1.jar"]
