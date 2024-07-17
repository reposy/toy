FROM ubuntu:latest
LABEL authors="hsykys0728"

ENTRYPOINT ["top", "-b"]
# Use an official JDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project's build artifacts to the container
COPY target/your-application.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]