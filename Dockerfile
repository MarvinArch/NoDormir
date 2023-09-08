
FROM maven:3.9.0-eclipse-temurin-11-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build target/EnvioGet-1.0-SNAPSHOT.jar clon.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "clon.jar"]