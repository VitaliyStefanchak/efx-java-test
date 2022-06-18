FROM openjdk:17-alpine
EXPOSE 8081
COPY ./target/subscriber-0.0.1.jar /tmp/
WORKDIR /tmp
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","subscriber-0.0.1.jar"]
