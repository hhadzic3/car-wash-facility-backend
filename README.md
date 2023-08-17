# car-wash-facility-backend
# Java Spring Boot (Data JPA) Application

This is a Java Spring Boot application that uses Data JPA to persist data in a database using PostgreSQL.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What you need to install the software and how to install them:

- Java 8 or later
- Maven 3.5 or later
- An IDE of your choice (e.g. IntelliJ IDEA)
- PostgreSQL

### Installing

1. Clone the repository to your local machine
2. Open the project in your IDE and configure the database connection properties in `src/main/resources/application.properties`.
3. Create DB (using tool like PgAdmin)
4. Build the project using Maven
5. Run the project

### Acknowledgments
- In `src/main/java/carwashfacility/services/DbInit` is DB initializer service (for creating initial data in DB). After first run this file should be commented !
- [Spring Initializer](https://start.spring.io/) - Used to generate the initial project structure
- [Spring Data JPA Guide](https://spring.io/guides/gs/accessing-data-jpa/) - Used as a reference for configuring Data JPA

## Env

Elephant SQL:
```properties
spring_profiles_active=prod
DB_HOST=trumpet.db.elephantsql.com
DB_PORT=5432
DB_NAME=krftoqpd
DB_PASSWORD=vDU73jeZeJOBE13Q2_wN6vfrjRKCEKdh
DB_USERNAME=krftoqpd
```

Railway PostgreSQL:
```properties
spring_profiles_active=prod
DB_HOST=containers-us-west-169.railway.app
DB_PORT=6909
DB_NAME=railway
DB_PASSWORD=dFATBRHm25GMXcrd34fS
DB_USERNAME=postgres
```
