# Stage 1: Build stage
FROM maven:3.8.1-openjdk-11 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and other necessary files first to leverage Docker cache
COPY pom.xml .

# Copy the rest of the application source code
COPY . .

# Build the application
RUN mvn clean install -DskipTests

# Stage 2: Production stage
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=builder /app/target/blog-api-docker.jar .

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "blog-api-docker.jar"]

# Expose the port the application listens on (assuming it's 8080, as mentioned in your original Dockerfile)
EXPOSE 8080
