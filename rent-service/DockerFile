FROM openjdk:8-alpine
EXPOSE 7575
ADD target/rent-service.jar rent-service.jar
ENTRYPOINT ["java","-jar","rent-service.jar"]