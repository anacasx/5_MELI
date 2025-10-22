# MELI Orders System

This project is a **Spring Boot 3.0** application developed for the **Digital NAO challenge** *"Spring and Spring Boot in Java for Web Applications."*  
It provides a **REST API** for managing orders in an online store, supporting CRUD operations (Create, Read, Update, Delete) connected to an **H2 database** for development purposes.

---

## 🧰 Prerequisites
- Java 17 or higher  
- Maven (or use the included `mvnw` wrapper)  
- Git  
- Postman (for testing the API)

---

## ⚙️ Setup and Execution

1. **Clone the repository**:
   ```bash
   git clone https://github.com/anacasx/5_MELI.git

---

## 🧩 Project Structure
```bash
src/main/java/com/meli/orders/
├── entity/
│   └── Order.java               # Entity representing an order
├── controller/
│   └── OrderController.java     # REST controller for CRUD operations
├── service/
│   └── OrderService.java        # Business logic for order management
└── repository/
    └── OrderRepository.java     # JPA repository for database operations
```

---

## 📖 Code Documentation

The code adheres to Java naming conventions and includes JavaDoc comments for all public classes, methods, and fields.

The project follows the MVC pattern for modularity and maintainability.

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
