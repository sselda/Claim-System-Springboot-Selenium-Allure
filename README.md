# Claim System (Spring Boot + Selenium + Allure)

Spring Boot application for managing insurance claims.
This project demonstrates backend development with Spring Boot, JPA, and JDBC, including REST endpoints and database interaction.

## Features
- Create insurance claims via HTTP requests
- Store claims in a relational database
- Process claims using a stored procedure
- Simple web form for manual input
- Clean layered architecture (Controller → Service → Repository)

## Tests
- API tests (JUnit)
- UI tests (Selenium WebDriver)

## Allure Report
Run:
./gradlew test
./gradlew allureServe

## Tech Stack
- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- JDBC (JdbcTemplate)
- Lombok
- H2 / MySQL / PostgreSQL (configurable)

## Project Structure

com.insurance.claimsystem
│
├── controller
│   └── ViewController.java
│
├── service
│   └── ClaimService.java
│
├── repository
│   ├── ClaimRepository.java (JPA)
│   └── ClaimJdbcRepository.java (JDBC)
│
├── model
│   └── Claim.java
│
└── resources
    ├── application.properties
    └── templates/
        └── claim-form.html

## Run Application
./gradlew bootRun
