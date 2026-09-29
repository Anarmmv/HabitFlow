# HabitFlow 🌱

HabitFlow is a web application for tracking and managing daily habits.

This project was built with Java and Spring Boot to practice backend development, authentication, database integration, and MVC architecture.

## ✨ Features

- 👤 User registration and login
- 🔐 User authentication with Spring Security
- ➕ Create new habits
- ✏️ Manage existing habits
- ⏸️ Activate and pause habits
- 📊 View habit statistics
- 👤 User profile
- 💾 Persistent data storage with H2 Database
- 🎨 Server-side rendered web interface with Thymeleaf

## 🛠️ Technologies

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

### Build & Tools

- Maven
- Git
- GitHub
- IntelliJ IDEA

## 🏗️ Project Architecture

The project follows a layered Spring Boot MVC architecture.

The application separates responsibilities between different layers to keep the code organized and maintainable.

- Controller
- Service
- Repository
- Entity
- Configuration

## 🔐 Authentication

Spring Security is used to handle user authentication and protect application pages.

Users can:

1. Register an account
2. Log in using their credentials
3. Access their personal dashboard
4. Manage their habits

Protected pages require the user to be authenticated.

## 📊 Habit Management

After logging in, users can manage their personal habits through the dashboard.

A habit can be:

- Created
- Managed
- Activated
- Paused

The application also provides a statistics page where users can view information about their habits.

## 💾 Database

HabitFlow uses H2 Database for data storage.

Spring Data JPA and Hibernate are used for communication between the Java application and the database.

Main entities include:

- User
- Habit
- HabitCompletion

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

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

The application will start on:

    http://localhost:8080

## H2 Database Console

The project includes an H2 database console for development and testing.

After starting the application, the console can be accessed at:

    http://localhost:8080/h2-console

Use the database configuration defined in:

    src/main/resources/application.properties

## 🎯 Project Goals

The main purpose of HabitFlow was to practice building a complete Java Spring Boot web application and understand how different backend technologies work together.

Through this project, I practiced:

- Building Spring Boot applications
- Working with Spring Security
- Creating JPA entities and repositories
- Connecting an application to a database
- Managing user authentication
- Following MVC architecture
- Building server-side rendered pages with Thymeleaf
- Using Git and GitHub for version control

## 🔮 Future Improvements

Possible future improvements include:

- REST API endpoints
- PostgreSQL database integration
- Habit reminders and notifications
- Habit streak tracking
- More detailed statistics
- REST API documentation with Swagger/OpenAPI
- Automated tests
- Docker support

## 👤 Author

Anar Məmmədov

GitHub: https://github.com/Anarmmv
