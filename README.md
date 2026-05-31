# Task Management System using Spring Boot & JWT Authentication

## Overview

This is a Task Management System developed using Spring Boot, MySQL, Spring Security, and JWT Authentication. The application allows users to register, log in, and manage tasks through secure REST APIs.

## Features

* User Registration
* User Login
* JWT Token Generation
* Secure API Access using Spring Security
* Create Task
* View Tasks
* Update Task
* Delete Task
* MySQL Database Integration
* JPA/Hibernate for Database Operations

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* MySQL
* Maven
* Git & GitHub

## Project Structure

src/
├── controller
├── service
├── repository
├── entity
├── security
└── resources

## API Endpoints

### Authentication

#### Register User

POST /auth/register

Request Body:

```json
{
  "username": "vani",
  "password": "1234"
}
```

#### Login User

POST /auth/login

Request Body:

```json
{
  "username": "vani",
  "password": "1234"
}
```

Response:

```text
JWT Token
```

### Task APIs

#### Get All Tasks

GET /tasks

#### Create Task

POST /tasks

#### Update Task

PUT /tasks/{id}

#### Delete Task

DELETE /tasks/{id}

## Security

* JWT-based Authentication
* Protected REST APIs
* Authorization Header Support

Example Header:

Authorization: Bearer <JWT_TOKEN>

## Database

MySQL is used as the backend database.

Example Configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/taskdb

spring.datasource.username=root

spring.datasource.password=your_password

## Learning Outcomes

Through this project, I learned:

* Spring Boot Development
* REST API Development
* Spring Security
* JWT Authentication
* JPA & Hibernate
* MySQL Integration
* Git & GitHub Workflow

## Author

Peramasani Vani
