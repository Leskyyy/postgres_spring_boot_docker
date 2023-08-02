#!/bin/sh

echo "Executing mvn install..."
mvn install -DskipTests
if [ $? -ne 0 ]; then
    echo "Maven build failed. Exiting script."
    exit 1
fi

echo "Building Docker image..."
docker build -t blog-api-docker.jar .
if [ $? -ne 0 ]; then
    echo "Docker build failed. Exiting script."
    exit 1
fi

echo "Starting Docker Compose..."
docker-compose up
if [ $? -ne 0 ]; then
    echo "Docker Compose failed. Exiting script."
    exit 1
fi
