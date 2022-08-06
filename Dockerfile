FROM openjdk:17-alpine
ADD target/car-1.0-SNAPSHOT.jar.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
