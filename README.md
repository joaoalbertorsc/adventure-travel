# Travel Adventure API

This is a simple Spring Boot API for managing travel adventures.

## Features

*   List all travel adventures.
*   Find adventures by country (case-insensitive).
*   Find adventures by state (case-insensitive).
*   Get a specific adventure by its ID.
*   Add new adventures.
*   Delete adventures.

## Technologies Used

*   **Java**: The core programming language for the application.
*   **Spring Boot**: The framework used to create the stand-alone, production-grade Spring-based application.
    *   **Spring Web**: Used for building the RESTful API endpoints.
    *   **Spring Data JPA**: Used for interacting with the database and simplifying data access layers.
*   **H2 Database**: An in-memory database used for development and testing purposes.
*   **Apache Maven**: A build automation and dependency management tool.
*   **Springdoc-openapi (Swagger)**: For generating interactive API documentation and UI.

## Testing and Development

To facilitate testing and development, this project includes two main tools:

### Swagger UI (OpenAPI)

Swagger UI allows you to visualize and interact with the API's resources without having any of the implementation logic in place. It's automatically generated from your OpenAPI (formerly Swagger) specification.

*   **URL**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Once the application is running, you can access the URL above to view all the available endpoints, test them with different parameters, and see the responses in real-time.

### H2 Database Console

The project uses an in-memory H2 database, and its console is enabled to allow you to view and manage the data directly.

*   **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
*   **JDBC URL**: `jdbc:h2:file:./data/travel-adventure`
*   **Username**: `sa`
*   **Password**: `sa`

Use the credentials above to log in to the console. There you can run SQL queries to inspect the tables and verify the data being persisted by the application.

## API Endpoints

| Method | Endpoint                               | Description                |
|--------|----------------------------------------|----------------------------|
| GET    | `/traveladventures`                    | Get all adventures.        |
| GET    | `/traveladventures/bycountry/{country}`| Get adventures by country. |
| GET    | `/traveladventures/bystate?state={state}` | Get adventures by state.   |
| GET    | `/traveladventures/{id}`               | Get an adventure by ID.    |
| POST   | `/traveladventures`                    | Create a new adventure.    |
| DELETE | `/traveladventures/{id}`               | Delete an adventure by ID. |
