# MELI Orders System

This project is a Spring Boot 3.0 application designed to manage orders for an online store, as part of the "Spring and Spring Boot in Java for Web Applications" challenge. It implements a REST API for CRUD operations on orders, connected to a PostgreSQL database.

---

## 🧰 Prerequisites
- **Java**: 17
- **Maven**: 3.8.0 or higher
- **PostgreSQL**: 13 or higher
- **Git**: For cloning the repository
- **Postman**: For testing the API

---

## ⚙️ Setup and Execution

1. **Clone the repository**:
   ```bash
   git clone https://github.com/anacasx/5_MELI.git
   cd meli-orders-system

---

## Install and Configure PostgreSQL
Ensure PostgreSQL is installed on your system:
```bash

sudo apt update
sudo apt install postgresql postgresql-contrib
```
Start PostgreSQL and enable it to run on boot:
```bash

sudo systemctl start postgresql
sudo systemctl enable postgresql
```
Create the database and user:
```bash
sudo -u postgres psql
```
In the PostgreSQL prompt, run:
```bash
CREATE DATABASE ordersdb;
CREATE USER meli_user WITH PASSWORD 'meli2025';
GRANT ALL PRIVILEGES ON DATABASE ordersdb TO meli_user;
\q
```

## Configure the Application
The database connection is configured in src/main/resources/application.properties:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/ordersdb
spring.datasource.username=meli_user
spring.datasource.password=meli2025
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Run the Application
Run the application (Linux):
```bash
./start.sh
```

The application will start on http://localhost:8080.

---

## 🔍 Testing the API

Import the Postman collection (MELI_Orders_API.postman_collection.json) into Postman to test the API.

| Method     | Endpoint           | Description              |
| :--------- | :----------------- | :----------------------- |
| **POST**   | `/api/orders`      | Create a new order       |
| **GET**    | `/api/orders/{id}` | Retrieve an order by ID  |
| **GET**    | `/api/orders`      | List all orders          |
| **PUT**    | `/api/orders/{id}` | Update an existing order |
| **DELETE** | `/api/orders/{id}` | Delete an order by ID    |

---

## 🧩 Project Structure
```bash
5_MELI/
├── src/
│   └── main/java/com/meli/orders/
│       ├── controller/
│       │   └── OrderController.java
│       ├── entity/
│       │   └── Order.java
│       ├── repository/
│       │   └── OrderRepository.java
│       ├── service/
│       │   └── OrderService.java
│       └── Application.java
├── MELI_Orders_API.postman_collection.json
├── start.sh
├── README.md
├── DECISIONS.md
├── pom.xml
```

---

## 📖 Code Documentation

The code adheres to Java naming conventions and includes JavaDoc comments for all public classes, methods, and fields.

The project follows the MVC pattern for modularity and maintainability.
