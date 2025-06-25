# Start with Java image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the project
RUN ./mvnw clean install

# Run the JAR
CMD ["java", "-jar", "target/weather-backend-0.0.1-SNAPSHOT.jar"]
