# EcomProject

EcomProject is a backend e-commerce application built using **Java and Spring Boot** that demonstrates the design and implementation of a production-style REST API for an online shopping platform.

The application supports core e-commerce functionality including **product management, order placement, and user-based order tracking**. It is designed with a layered architecture using **DTOs, service layers, repositories, and entity relationships** to ensure clean separation of concerns and maintainability.

Key features implemented so far include:

* **Product Management** – CRUD APIs for managing products with pagination, sorting, and dynamic filtering using Spring Data JPA Specifications.
* **Order Processing** – Users can place orders containing multiple products, with automatic stock validation and total amount calculation.
* **Entity Relationships** – Proper relational modeling between **User → Order → OrderItem → Product** using JPA.
* **DTO-Based API Design** – Request and response DTOs are used to avoid exposing database entities directly and to prevent serialization issues.
* **Inventory Safety** – Implementation of **optimistic locking** to prevent race conditions and overselling of product stock when multiple users attempt to purchase the same item simultaneously.
* **RESTful API Design** – Clean and structured REST endpoints for product browsing, order placement, and retrieving user orders.

This project focuses on **real-world backend engineering concepts** such as concurrency handling, database relationships, and scalable API design using Spring Boot.
