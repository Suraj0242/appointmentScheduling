# Use official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package the application (skip tests for faster build)
RUN mvn clean package -DskipTests

# Use lightweight JDK image for running the app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]