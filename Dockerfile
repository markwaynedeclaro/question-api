# Step 1: Use an image with Gradle and OpenJDK 21 pre-installed
FROM openjdk:21-jdk-slim as build

# Step 2: Set environment variables
ENV GRADLE_VERSION=8.11.1
ENV GRADLE_HOME=/opt/gradle

# Step 3: Install required dependencies
RUN apt update && apt install -y unzip wget curl \
    && wget https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -P /tmp \
    && unzip /tmp/gradle-${GRADLE_VERSION}-bin.zip -d /opt/gradle \
    && ln -s /opt/gradle/gradle-${GRADLE_VERSION}/bin/gradle /usr/bin/gradle

# Step 4: Set the working directory
WORKDIR /app

# Step 5: Copy project files
COPY . /app/

# Step 6: Verify Gradle installation
RUN gradle --version

# Run Gradle wrapper on its own to cache the gradle installation
COPY ./gradlew gradlew
COPY ./gradle/ gradle/
RUN ./gradlew

# Run the actual gradle
COPY . .
RUN ./gradlew build

# Step 7: Build the application
#RUN gradle build --no-daemon

# Step 8: Use a lightweight JDK 21 image to run the app
FROM openjdk:21-jdk-slim

# Step 9: Set the working directory in the container
WORKDIR /app

# Step 10: Copy the built .jar file from the previous stage
COPY --from=build /app/build/libs/*.jar app.jar

# Step 11: Expose the port your Spring Boot app runs on
EXPOSE 80

# Step 12: Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]