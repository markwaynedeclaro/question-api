FROM gradle:8.11.1-jdk21 AS build

WORKDIR /app
COPY . .

RUN gradle build --no-daemon

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 80

ENTRYPOINT ["java","-jar","app.jar"]