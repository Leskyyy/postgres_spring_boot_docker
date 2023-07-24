https://www.section.io/engineering-education/running-a-multi-container-springboot-postgresql-application-with-docker-compose/

mvn install -DskipTests

docker build -t blog-api-docker.jar .

docker-compose up