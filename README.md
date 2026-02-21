# 🏋️ Fitness Tracker API (Spring Boot + JWT)

A secure and scalable Fitness Tracking REST API built using **Spring Boot**, **Spring Security (JWT)**, and **PostgreSQL**.

This project demonstrates authentication, authorization, secure endpoints, and clean API documentation using Swagger (OpenAPI).

---

## 🚀 Features

- 🔐 JWT-based Authentication
- 👤 User Registration & Login
- 🛡 Role-based Authorization
- 📊 Activity Tracking
- 🧠 Personalized Recommendations
- 📖 Swagger API Documentation
- 🗄 PostgreSQL Database Integration
- ⚙️ Spring Security 6/7 Configuration
- ❌ Custom Global Exception Handling
- 🔒 Custom AccessDeniedHandler for 403 errors

---

## 🏗 Tech Stack

- Java 17+
- Spring Boot 3+
- Spring Security 6/7
- JWT (JSON Web Token)
- PostgreSQL
- Hibernate / JPA
- Swagger (Springdoc OpenAPI)
- Maven

---

## 📂 Project Structure

```
com.project.fitnessMonolithic
│
├── controller        # REST Controllers
├── service           # Business Logic
├── repository        # JPA Repositories
├── model             # Entity Classes
├── config            # Security & Swagger Config
├── security          # JWT Filter & Utilities
└── exception         # Global Exception Handling
```

---

## 🔐 Authentication Flow (JWT)

1️⃣ User registers or logs in.  
2️⃣ Credentials are authenticated using AuthenticationManager.  
3️⃣ JWT token is generated.  
4️⃣ Client sends token in request header:

```
Authorization: Bearer your_jwt_token
```

5️⃣ Custom JWT filter validates token before accessing secured endpoints.  
6️⃣ Access is granted based on roles and authorities.

---

## 📌 API Endpoints

### 🔑 Authentication

| Method | Endpoint        | Description              |
|--------|-----------------|--------------------------|
| POST   | /auth/register  | Register new user        |
| POST   | /auth/login     | Login & receive JWT      |

---

### 🏃 Activities

| Method | Endpoint           | Description                 |
|--------|--------------------|-----------------------------|
| POST   | /activities        | Add new activity            |
| GET    | /activities        | Get all user activities     |
| GET    | /activities/{id}   | Get activity by ID          |
| DELETE | /activities/{id}   | Delete activity             |

---

## 📖 Swagger Documentation

After starting the application:

```
http://localhost:8080/swagger-ui/index.html
```

Use the **Authorize 🔒 button** and enter:

```
Bearer your_jwt_token
```

---

## ⚙️ application.properties Example

```
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/fitnessdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT (Example)
jwt.secret=yourSecretKey
jwt.expiration=3600000
```

---

## 🛡 Security Configuration

- CSRF Disabled (Stateless REST API)
- SessionCreationPolicy.STATELESS
- Custom JWT Filter
- Custom AuthenticationEntryPoint (401)
- Custom AccessDeniedHandler (403)
- Swagger endpoints permitted

---

## 🗄 Database Schema Overview

### User
- id
- username (unique)
- email
- password
- role

### Activity
- id
- user_id (Foreign Key)
- type
- recommendation
- improvements
- suggestions
- safety

---

## 🧪 How To Run The Project

1️⃣ Clone repository:

```
git clone https://github.com/yourusername/fitness-app.git
```

2️⃣ Configure PostgreSQL in `application.properties`

3️⃣ Run application:

```
mvn spring-boot:run
```

4️⃣ Open Swagger UI.

---

## 🧠 Key Learning Concepts Implemented

- Spring Security filter chain flow
- JWT token creation & validation
- Role-based authorization
- Custom exception handling
- Handling 401 vs 403 properly
- Swagger configuration with JWT support
- Git conflict resolution workflow

---

## 🔥 Future Improvements

- Refresh Token Implementation
- Email Verification
- Password Reset Flow
- Docker Support
- CI/CD Pipeline
- Deployment (AWS / Render / Railway)
- Microservices Architecture Upgrade

---

## 👨‍💻 Author

**Deepak Singh**  
Backend Developer 

---
