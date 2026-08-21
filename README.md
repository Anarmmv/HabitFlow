# HabitFlow 🌱

HabitFlow is a simple web application for tracking and managing daily habits.

The project was developed as a practical Spring Boot project to improve backend development skills and gain hands-on experience with Java, Spring Security, Spring Data JPA, and database integration.

## ✨ Features

* 👤 User registration and login
* 🔐 User authentication with Spring Security
* ➕ Create new habits
* ✏️ Manage existing habits
* ⏸️ Activate and pause habits
* 📊 View habit statistics
* 👤 User profile
* 💾 Persistent data storage with H2 Database
* 🎨 Simple and responsive web interface

## 🛠️ Technologies

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* H2 Database

### Frontend

* Thymeleaf
* HTML
* CSS

### Build & Tools

* Maven
* Git
* GitHub
* IntelliJ IDEA

## 🏗️ Project Structure

The project follows a typical Spring Boot MVC architecture:

```text
src
└── main
    ├── java
    │   └── ...
    │       ├── controller
    │       ├── service
    │       ├── repository
    │       ├── entity
    │       └── config
    │
    └── resources
        ├── templates
        ├── static
        └── application.properties
```

The application separates responsibilities between different layers to keep the code organized and maintainable.

## 🔐 Authentication

Spring Security is used to protect application pages and handle user authentication.

Users can:

1. Register an account
2. Log in using their credentials
3. Access their personal dashboard
4. Manage their habits

Protected pages require the user to be authenticated.

## 📊 Habit Management

After logging in, users can manage their personal habits through the dashboard.

A habit can be:

* Created
* Managed
* Activated
* Paused

The application also provides a statistics page where users can view information about their habits.

## 💾 Database

HabitFlow uses **H2 Database** for data storage.

Spring Data JPA and Hibernate are used for communication between the Java application and the database.

Main entities include:

* `User`
* `Habit`
* `HabitCompletion`

##  Getting Started

### Prerequisites

Make sure you have the following installed:

* Java 26 
* Maven
* Git

### Clone the repository

```bash
git clone https://github.com/Anarmmv/HabitFlow.git
```

Navigate to the project:

```bash
cd HabitFlow
```

### Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

##  H2 Database Console

The project includes an H2 database console for development and testing.

After starting the application, the console can be accessed at:

```text
http://localhost:8080/h2-console
```

Use the database configuration defined in:

```text
src/main/resources/application.properties
```

##  Purpose of the Project

The main purpose of HabitFlow was to practice building a complete Java Spring Boot web application and understand how different backend technologies work together.

Through this project, I practiced:

* Building Spring Boot applications
* Working with Spring Security
* Creating JPA entities and repositories
* Connecting an application to a database
* Managing user authentication
* Following MVC architecture
* Building server-side rendered pages with Thymeleaf
* Using Git and GitHub for version control

 Future Improvements

Possible future improvements include:

* REST API endpoints
* PostgreSQL database integration
* Habit reminders and notifications
* Habit streak tracking
* More detailed statistics
* REST API documentation with Swagger/OpenAPI
* Automated tests
* Docker support

##  Author

**Anar Məmmədov**

GitHub:
https://github.com/Anarmmv
