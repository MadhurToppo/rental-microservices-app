#FROM openjdk:8-alpine
#EXPOSE 7272
#ADD target/customer-service.jar customer-service.jar
#ENTRYPOINT ["java","-jar","customer-service.jar"]
FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim

# Use the official maven/Java 8 image to create a build artifact.
# https://hub.docker.com/_/maven
#FROM maven:3.5-jdk-8-alpine as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml ./

#Copy the maven dependencies in offline mode
#RUN mvn dependency:go-offline

COPY src ./src/

# Build a release artifact.
#RUN mvn clean package -DskipTests

# Use AdoptOpenJDK for base image.
# It's important to use OpenJDK 8u191 or above that has container support enabled.
# https://hub.docker.com/r/adoptopenjdk/openjdk8
# https://docs.docker.com/develop/develop-images/multistage-build/#use-multi-stage-builds
#FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim

# Copy the jar to the production image from the builder stage.
#COPY --from=builder /app/target/customer-service.jar /customer-service.jar

COPY target/customer-service.jar ./customer-service.jar

# Run the web service on container startup.
CMD ["java","-jar","customer-service.jar"]

#ENTRYPOINT ["java","-jar","customer-service.jar"]