# API-Product

A RESTful API built with **Java** and **Spring Boot** for managing product data.  
It provides CRUD operations and supports both **H2 (in-memory)** and **PostgreSQL** databases, making it suitable for development, testing, and production environments.

---

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Database Configuration](#database-configuration)
- [API Endpoints](#api-endpoints)
- [Data Model](#data-model)
- [Error Handling](#error-handling)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## Features

- Create, update, delete, and retrieve products  
- Configurable database support (H2 and PostgreSQL)  
- Input validation using Spring  
- Global exception handling  
- Layered architecture following best practices  

---

## Technologies

- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Maven  
- **H2 Database (Development/Test)**  
- **PostgreSQL (Production/Local)**  

---

## Getting Started

### Prerequisites

Install the following before running the project:

- Java JDK (21 or newer)
- Maven
- PostgreSQL (if using the production database profile)

### Installation

Clone the repository:

```bash
git clone https://github.com/josivantarcio/API-Product.git
cd API-Product
Build the project:

bash
mvn clean install
Running the Application
To run with the default profile (using H2):

bash
mvn spring-boot:run
To run with PostgreSQL:

bash
mvn spring-boot:run -Dspring-boot.run.profiles=postgres
Database Configuration
✔ H2 Database (default)
Located in application.properties:

properties
spring.datasource.url=jdbc:h2:mem:productsdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
✔ PostgreSQL Database
Located in application-postgres.properties:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/productsdb
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
API Endpoints
Method	Endpoint	Description
GET	/products	Get all products
GET	/products/{id}	Get product by ID
POST	/products	Create a new product
PUT	/products/{id}	Update a product
DELETE	/products/{id}	Remove a product

Data Model
java
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
}
Error Handling
The API returns proper status codes and structured error responses.

Example:

json
{
  "timestamp": "2025-11-18T12:40:12",
  "status": 404,
  "message": "Product not found",
  "path": "/products/10"
}
Contributing
Fork the repository

Create a new branch:

bash
git checkout -b feature/new-feature
Commit your changes

Push your branch

Open a Pull Request

License
This project is licensed under the MIT License (or update if you choose another license).

Contact

Author: Josevan Oliveira

LinkedIn: https://www.linkedin.com/in/josevanoliveira/
GitHub: https://github.com/josivantarcio
Portfolio: https://josivantarcio.github.io/my-portfolio/
