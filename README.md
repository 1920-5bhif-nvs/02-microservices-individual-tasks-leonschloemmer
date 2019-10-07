# Homework Example

This homework contains 2 microservices for a little application generating "revision dates" for a learned topic. One Service takes care of storing the chapters, another takes care of calculating revision dates for a topic.

## Structure

The chapters project offers an endpoint for reading and creating chapters.
The date project offers and endpoint for dates.

chapters uses JPA to persist chapters in a PostgreSQL database.
Configure the database connection in the chapters/src/main/resources/application.properties file.

## Starting the projects

Start both projects in their home directories with ./mvnw compile quarkus:dev

## Endpoints

### Create a new topic / chapter

POST at localhost:8080/chapters?name={name}

### Read all chapters

GET at localhost:8080/chapters

## Metrics

All with Accept : application/json header.

GET at localhost:8080/metrics/application
GET at localhost:8181/metrics/application

## Health

All with Accept : application/json header.

GET at localhost:8080/health/ready

Checks if the database is running and can be connected to
