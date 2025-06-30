# Use a lightweight Java runtime image
FROM eclipse-temurin:17-jre-alpine

# Set the working directory
WORKDIR /app

# Expose port (optional, useful for local testing)
EXPOSE 8081

# Copy the Spring Boot JAR into the container
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
