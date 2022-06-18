FROM openjdk:17-alpine
EXPOSE 8082
COPY ./target/client-0.0.1.jar /tmp/
WORKDIR /tmp
ENTRYPOINT ["java","-jar","client-0.0.1.jar"]
