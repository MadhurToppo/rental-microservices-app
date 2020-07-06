FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim
WORKDIR /app
COPY pom.xml ./
COPY src ./src/
COPY target/product-service.jar ./product-service.jar
CMD ["java","-jar","product-service.jar"]