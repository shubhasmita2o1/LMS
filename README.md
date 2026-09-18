# University LMS – Advanced University Digital Learning & Academic Platform

Modular Monolith designed to evolve into Microservices.

## Tech Stack

- **Backend**: Java 21, Spring Boot 4.1.1, Spring Security, Spring Data JPA, Hibernate
- **Database**: PostgreSQL + Redis (later)
- **Frontend** (coming): React + Vite + JavaScript + Tailwind + Ant Design

## Project Structure (Modular Monolith)

```
com.university.lms
├── auth              # Authentication & JWT
├── users             # User management
├── university        # University / Campus / School
├── academic          # Hierarchy, Programs, Batches, Semesters
├── students          # Student Information System
├── faculty           # Faculty management
├── courses           # Course & Curriculum
├── lms               # Core theory learning (content, videos, progress)
├── practical         # Labs, code execution, experiments
├── assessment        # Assignments, Quizzes, Question Bank
├── examination       # Online exams, proctoring
├── attendance
├── results           # Gradebook, GPA, CGPA
├── finance           # Fees
├── library
├── admission
├── placement
├── communication     # Announcements, messaging
├── analytics
├── audit
├── common            # Shared utilities, BaseEntity, ApiResponse
├── config
├── security
└── exception
```

## Getting Started

### Prerequisites
- Java 21+
- PostgreSQL running on `localhost:5432`
- Database: `university_lms`
- User: `lms_user` / Password: `lms_password`

### Run

```bash
./mvnw spring-boot:run
```

Health check: [http://localhost:8080/api/v1/public/health](http://localhost:8080/api/v1/public/health)

## Development Roadmap

See the master plan document (University LMS Plan.pdf).

Current focus: **Phase 1 – Project Foundation** (Days 6–10)
