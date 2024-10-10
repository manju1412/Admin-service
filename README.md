# Admin Service

This Spring Boot application provides a RESTful API for managing admin users.  It uses Spring Data JPA for database interaction and PostgreSQL as the database.

## Features

* **CRUD Operations:** Create, Read, Update, and Delete admin users.
* **Password Security:** Passwords are hashed using BCrypt for enhanced security.
* **Account Status:**  Tracks admin user status (active/inactive).
* **Login Tracking:**  Records last login time. (Future implementation: Login attempt tracking and account locking.)
* **CORS Enabled:** Configured for cross-origin requests from `http://localhost:4200` (configurable).


## Getting Started

### Prerequisites

* Java 21 JDK or higher
* Maven 3.3.2 or higher (included as a wrapper - `mvnw`)
* PostgreSQL database server running and accessible.
* An IDE (like IntelliJ IDEA or Eclipse) is recommended.


### Installation

1. **Clone the repository:**

   ```bash
   git clone >
content_copy
Use code with caution.
Markdown

Navigate to the project directory:

cd adminservice
content_copy
Use code with caution.
Bash

Build the application:

./mvnw clean install
content_copy
Use code with caution.
Bash

Run the application:

./mvnw spring-boot:run
content_copy
Use code with caution.
Bash
Database Setup

Ensure you have a PostgreSQL database server running (e.g. locally on port 5432).

Create a database named "admindb".

Create a PostgreSQL user with credentials matching what is in application.properties (default postgres/12345 - change this in a production environment!).

Grant necessary permissions on that database to that user.

API Endpoints
Method	Endpoint	Description
GET	/admin	Retrieves all admin users.
GET	/admin/{id}	Retrieves a specific admin user by ID.
POST	/admin	Creates a new admin user.
PUT	/admin/{id}	Updates an existing admin user by ID (full update).
DELETE	/admin/{id}	Deletes an admin user by ID.
Request/Response Examples (using curl)

Create Admin:

curl -X POST -H "Content-Type: application/json" -d '{
  "username": "newadmin",
  "rawPassword": "securepassword",  // Use the rawPassword field
  "email": "newadmin@example.com",
  "active": true
}' http://localhost:8080/admin
content_copy
Use code with caution.
Bash

Get Admin by ID:

curl http://localhost:8080/admin/1
content_copy
Use code with caution.
Bash
Development
IDE Setup

Import the project into your IDE as a Maven project.

Running Tests
./mvnw test
content_copy
Use code with caution.
Bash
Security Considerations

Password Hashing: Passwords are hashed using BCrypt. Never store passwords in plain text.

CORS: The application is configured to allow cross-origin requests from http://localhost:4200. Adjust the allowedOrigins property in AdminConfig.java if needed.

HTTPS: In a production environment, use HTTPS to secure communication.

Input Validation: Input validation should be implemented to prevent vulnerabilities like SQL injection and cross-site scripting (XSS).

Future Enhancements

Login Attempt Tracking and Account Locking: Implement logic to track failed login attempts and lock accounts after a certain threshold.

Role-Based Access Control (RBAC): Implement RBAC to manage permissions and access to different parts of the application.

OAuth 2.0 Integration: Integrate with OAuth 2.0 for secure authentication and authorization.

More Comprehensive Error Handling: Provide more detailed error responses with appropriate HTTP status codes.

API Documentation: Generate API documentation using Swagger or a similar tool.

Contributing

Contributions are welcome! Please follow these steps:

Fork the repository.

Create a new branch for your feature or bug fix.

Make your changes and commit them.

Push your changes to your forked repository.

Create a pull request.

