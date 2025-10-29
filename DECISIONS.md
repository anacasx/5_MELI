# Project Decisions

This document outlines key decisions made during the development of the Order Management System for the "Spring and Spring Boot in Java for Web Applications" challenge, covering Sprint 1 and Sprint 2.

## Sprint 1 Decisions
1. **Database Choice**:
   - **Decision**: PostgreSQL was chosen as the database for both development and production environments.
   - **Justification**: PostgreSQL provides robustness, scalability, and reliability, making it suitable for handling order data in a production-ready system. This choice ensures consistency across environments, avoiding the need to switch databases later.

2. **Project Structure**:
   - **Decision**: The project follows the Model-View-Controller (MVC) pattern with distinct layers for controllers, services, repositories, and entities.
   - **Justification**: This modular structure improves maintainability, testability, and scalability. It aligns with Spring Boot best practices and facilitates future enhancements.

3. **Basic Functionality Prioritization**:
   - **Decision**: Focused on implementing core CRUD operations (Create, Read, Update, Delete) for the order resource without advanced validations in Sprint 1.
   - **Justification**: Prioritizing basic functionality ensures a solid foundation for the API, allowing time to meet Sprint 1 deadlines. Advanced validations will be addressed in Sprint 3.

4. **REST API Design**:
   - **Decision**: Implemented a RESTful API with endpoints under `/api/orders` for CRUD operations.
   - **Justification**: A RESTful approach ensures simplicity, scalability, and compatibility with standard HTTP methods, making it easy to test with tools like Postman.

5. **Code Documentation**:
   - **Decision**: Used JavaDoc for documenting all public classes, methods, and fields.
   - **Justification**: JavaDoc provides clear and standardized documentation, improving code readability and maintainability for future developers and evaluators.

6. **Startup Script for Ubuntu**:
   - **Decision**: Created a `start.sh` script to automate the application startup process.
   - **Justification**: The script simplifies deployment on Ubuntu systems, reducing manual errors and ensuring consistent execution.

## Sprint 2 Decisions
1. **Environment Profiles**:
   - **Decision**: Configured three Spring profiles (`dev`, `test`, `prod`) with separate YAML files (`application-dev.yml`, `application-test.yml`, `application-prod.yml`).
   - **Justification**: Profiles allow environment-specific configurations, ensuring flexibility and isolation between development, testing, and production environments. Different database schemas and ports were assigned to each profile.

2. **Separate Databases**:
   - **Decision**: Created three PostgreSQL databases (`ordersdb_dev`, `ordersdb_test`, `ordersdb_prod`) for each environment.
   - **Justification**: Separate databases prevent data conflicts and allow independent testing and development workflows. The `create-drop` strategy in testing ensures a clean state for each run.

3. **Environment Variables for Production**:
   - **Decision**: Used environment variables (`DB_URL`, `DB_USERNAME`, `DB_PASSWORD`) in the production profile to avoid hardcoding sensitive information.
   - **Justification**: This approach enhances security by keeping credentials out of the codebase and allows dynamic configuration during deployment.

4. **Port Differentiation**:
   - **Decision**: Assigned different ports (8080 for dev, 8081 for test, 8082 for prod) to each profile.
   - **Justification**: Different ports prevent conflicts when running multiple instances of the application locally, simulating real-world deployment scenarios.

5. **Peer Review Simulation**:
   - **Decision**: Conducted a simulated peer review to verify profile configurations and database connectivity.
   - **Justification**: Early detection of integration issues ensures a stable foundation for Sprint 3 testing and documentation.

## Issues Identified
1. **Issue**: Application failed to start due to invalid `spring.profiles.active` property in `application-dev.yml`.
   - **Resolution**: Removed `spring.profiles.active` from profile-specific YAML files, as it should only be defined in `application.properties` or via command-line arguments.
2. **Issue**: Application attempted to use H2 driver for PostgreSQL URL (`jdbc:postgresql://localhost:5432/ordersdb_dev`).
   - **Resolution**: Removed H2 dependency from `pom.xml` and explicitly set `driver-class-name: org.postgresql.Driver` in configuration files to ensure PostgreSQL is used.
3. **Issue**: Permission denied for schema `public` when creating the `orders` table in `ordersdb_dev` and `ordersdb_test`.
   - **Resolution**: Granted `ALL` privileges on the `public` schema to `meli_user` for all databases using `GRANT ALL ON SCHEMA public TO meli_user`.
4. **Issue**: Profile `test` not loaded when specified via `-Dspring.profiles.active=test`.
   - **Resolution**: Removed `spring.profiles.active=dev` from `application.properties` and used `-Dspring-boot.run.profiles=test` to ensure the correct profile is activated.
5. **Issue**: PostgreSQL error `invalid integer value "ON" for connection option "port"` when executing `\c` and `GRANT` commands.
   - **Resolution**: Executed commands individually in `psql`, ensuring proper connection to each database before granting permissions.
6. **Issue**: Application failed to start with profile `test` due to `Failed to configure a DataSource: 'url' attribute is not specified`.
   - **Resolution**: Ensured `application.properties` does not override the profile and used `-Dspring-boot.run.profiles=test` to activate the `test` profile correctly.
7. **Issue**: Application failed to start with profile `prod` due to `Schema-validation: missing table [orders]`.
   - **Resolution**: Manually created the `orders` table in `ordersdb_prod` using a SQL script to match the `Order` entity, as `hibernate.ddl-auto=validate` requires the schema to preexist.
8. **Issue**: HTTP 500 error when creating order via POST.
   - **Resolution**: The `orderDate` field in the JSON payload was missing the timezone (`Z`). Updated all POST requests to use ISO 8601 format with `Z` (e.g., `2025-10-24T10:00:00Z`).

## Future Considerations
- In Sprint 3, Swagger will be integrated for API documentation, and comprehensive unit and integration tests will be developed to validate functionality across all profiles.
- Consider implementing a secrets management tool (e.g., Vault) for production environments to further enhance security.


## Author
- Xóchitl Cabañas
- NAO ID: 3319
- Date: October 28, 2025