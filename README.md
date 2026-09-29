# HabitFlow

HabitFlow is a web application for creating and managing daily habits.

The project is built with Java and Spring Boot and includes user authentication, habit management, statistics, and database integration.

## Features

- User registration and login
- User authentication with Spring Security
- Create and manage habits
- Activate and pause habits
- Track habit completion
- View habit statistics
- User profile
- H2 database integration

## Technologies

### Backend

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate

### Database

- H2 Database

### Frontend

- Thymeleaf
- HTML
- CSS

### Tools

- Maven
- Git
- GitHub
- IntelliJ IDEA

## Project Structure

The project follows a layered Spring Boot MVC structure.

- `controller` - handles HTTP requests
- `service` - contains application logic
- `repository` - handles database operations
- `entity` - contains JPA entities
- `config` - contains application and security configuration

## Authentication

Spring Security is used for user authentication and access control.

Users can register, log in, and access their personal pages after authentication.

## Habit Management

After logging in, users can create and manage their habits.

The application allows users to:

- Create habits
- Activate habits
- Pause habits
- Track habit completion
- View statistics

## Database

HabitFlow uses H2 as the database.

Spring Data JPA and Hibernate are used to work with the database.

Main entities:

- `User`
- `Habit`
- `HabitCompletion`

## Getting Started

### Prerequisites

- Java 26
- Git

### Clone the repository

    git clone https://github.com/Anarmmv/HabitFlow.git
    cd HabitFlow

### Run the application

On macOS/Linux:

    ./mvnw spring-boot:run

On Windows:

    mvnw.cmd spring-boot:run

The application runs on:

    http://localhost:8080

## H2 Console

The H2 database console is available at:

    http://localhost:8080/h2-console

Database configuration can be found in:

    src/main/resources/application.properties

## What I Practiced

While working on HabitFlow, I practiced:

- Building applications with Spring Boot
- Creating REST and MVC components
- Working with Spring Security
- Creating JPA entities and repositories
- Connecting Java applications to a database
- Implementing user authentication
- Using Thymeleaf
- Working with Git and GitHub

## Future Improvements

- REST API
- PostgreSQL integration
- Habit reminders
- Habit streak tracking
- More detailed statistics
- Swagger/OpenAPI documentation
- Automated tests
- Docker support

## Author

Anar Məmmədov

GitHub: https://github.com/Anarmmv
