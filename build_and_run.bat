@echo off
setlocal

echo Executing mvn install...
call mvn install -DskipTests
if %ERRORLEVEL% neq 0 (
    echo Maven build failed. Exiting script.
    pause
    exit /b 1
)

echo Building Docker image...
docker build -t blog-api-docker.jar .
if %ERRORLEVEL% neq 0 (
    echo Docker build failed. Exiting script.
    pause
    exit /b 1
)

echo Starting Docker Compose...
docker-compose up
if %ERRORLEVEL% neq 0 (
    echo Docker Compose failed. Exiting script.
    pause
    exit /b 1
)

endlocal
