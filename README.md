 🚀 Job Portal Backend API

A scalable RESTful backend system** for a Job Portal platform built with Spring Boot.

This application allows **candidates to search and apply for jobs**, while **recruiters can post and manage job listings**.
The system also supports **resume upload, application tracking, job filtering, and dashboard analytics**.

The backend is designed using **clean architecture principles** and exposes REST APIs that can be integrated with **web, mobile, or frontend frameworks like React or Angular**.

---

 📌 Project Overview

The Job Portal Backend API provides the core backend services required for a complete job portal platform.

It supports:

• User authentication
• Recruiter management
• Job posting and management
• Job applications
• Resume upload & file management
• Job search and filtering
• Skills management
• Dashboard analytics

The project follows a **layered architecture**:

Controller → Service → Repository → Database

---

 🏗 System Architecture

Client (Frontend / Mobile App)

↓

REST API (Spring Boot Controllers)

↓

Service Layer (Business Logic)

↓

Repository Layer (Spring Data JPA)

↓

MySQL Database

---

 ✨ Features

 👤 User Management

* Register new users
* Login authentication
* View user details
* Update user profiles

 🧑‍💼 Recruiter Management

* Create recruiter accounts
* Update recruiter details
* View recruiters
* Delete recruiters

 💼 Job Management

* Create job postings
* Update job information
* Delete job listings
* View all jobs
* Search jobs
* Filter jobs
* Sort job results
* Pagination support
* Skill-based job search

 📄 Job Applications

* Apply for jobs
* View applications
* Update application status
* View applications by job ID

 📎 Resume Management

* Upload resume files
* Download resume
* View uploaded resume

 🧠 Skills Module

* Add new skills
* Retrieve available skills

 📊 Dashboard

* Platform statistics
* Job counts
* Application counts

---

 🛠 Tech Stack

Backend Framework
• Spring Boot

Programming Language
• Java

ORM
• Spring Data JPA
• Hibernate

Database
• MySQL

Build Tool
• Maven

Other Technologies
• REST API
• Multipart File Upload

---

 📂 Project Structure

src/main/java

controller
Handles HTTP requests and API endpoints

service
Contains business logic

repository
Handles database operations using Spring Data JPA

entity / model
Database entity classes

dto
Data transfer objects

config
Application configuration

---

🔗 API Documentation

 🔐 Authentication API

POST /api/auth/register
Register a new user

POST /api/auth/login
Authenticate user

---

 👤 User API

GET /api/users/{id}
Get user by ID

PUT /api/users/{id}
Update user profile

GET /api/users
Get all users

---

 🧑‍💼 Recruiter API

GET /api/recruiters/{id}

PUT /api/recruiters/{id}

DELETE /api/recruiters/{id}

GET /api/recruiters

POST /api/recruiters

---

 💼 Jobs API

GET /api/jobs
Get all jobs

POST /api/jobs
Create job

GET /api/jobs/{id}
Get job details

PUT /api/jobs/{id}
Update job

DELETE /api/jobs/{id}
Delete job

Advanced Query APIs

GET /api/jobs/search
Search jobs

GET /api/jobs/filter
Filter jobs

GET /api/jobs/page
Pagination support

GET /api/jobs/sort
Sort jobs

GET /api/jobs/skill
Find jobs by skill

---

 📄 Applications API

POST /api/applications
Apply for job

GET /api/applications
Get all applications

GET /api/applications/job/{jobId}
Get applications for a specific job

PUT /api/applications/{id}/status
Update application status

---

 📎 Resume File API

POST /api/files/upload
Upload resume

GET /api/files/download/{fileName}
Download resume

GET /api/files/view/{fileName}
View resume

---

 🧠 Skills API

GET /api/skills
Get all skills

POST /api/skills
Create skill

---

 📊 Dashboard API

GET /api/dashboard/stats
Retrieve dashboard statistics

---

 ⚙️ Installation & Setup

 1️⃣ Clone Repository

git clone https://github.com/parthiban1716/job-portal-backend.git

 2️⃣ Navigate to Project

cd job-portal-backend

 3️⃣ Configure Database

Update application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
spring.datasource.username=root
spring.datasource.password=yourpassword

 4️⃣ Build Project

mvn clean install

 5️⃣ Run Application

mvn spring-boot:run

Server runs at

http://localhost:8080

---

 🗄 Database Design

Main tables:

Users
Recruiters
Jobs
Applications
Skills
Files

Relationships are implemented using **Hibernate/JPA annotations**:

• OneToMany
• ManyToOne
• OneToOne

---

 📌 Example API Request

Create Job

POST /api/jobs

Request Body

{
"title": "Java Developer",
"description": "Spring Boot Developer",
"location": "Chennai",
"salary": "8 LPA"
}

---

 📈 Future Improvements

• JWT Authentication
• Role Based Authorization
• Resume Parsing
• Email Notifications
• Admin Dashboard
• Docker Deployment
• Microservices Architecture

---

 👨‍💻 Author

Parthiban

GitHub
https://github.com/parthiban1716

---

⭐ Support

If you like this project, consider giving it a **star ⭐ on GitHub**.

---

📜 License

This project is open-source and available for educational purposes.

---
