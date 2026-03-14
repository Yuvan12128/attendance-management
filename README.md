# Attendance Management System (College)

Full-stack blueprint using **React (Vite) + Spring Boot + MySQL + JWT** with role-based dashboards for **ADMIN**, **STAFF**, and **STUDENT**.

## 1) Production-ready project structure

```text
attendance-management/
├── backend/
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/college/attendance/
│       │   ├── AttendanceApplication.java
│       │   ├── config/
│       │   │   └── SecurityConfig.java
│       │   ├── controller/
│       │   │   ├── AuthController.java
│       │   │   ├── AdminController.java
│       │   │   ├── StaffController.java
│       │   │   └── StudentController.java
│       │   ├── dto/
│       │   ├── entity/
│       │   ├── enums/
│       │   ├── repository/
│       │   ├── security/
│       │   └── service/
│       └── resources/
│           └── application.yml
├── frontend/
│   ├── package.json
│   ├── index.html
│   ├── vite.config.js
│   └── src/
│       ├── api/client.js
│       ├── components/ProtectedRoute.jsx
│       ├── context/AuthContext.jsx
│       ├── pages/
│       │   ├── LoginPage.jsx
│       │   ├── AdminDashboard.jsx
│       │   ├── StaffDashboard.jsx
│       │   ├── StudentDashboard.jsx
│       │   ├── AttendanceMarkPage.jsx
│       │   └── ReportsPage.jsx
│       ├── router/AppRouter.jsx
│       └── main.jsx
├── database/schema.sql
└── docs/rest-api-endpoints.md
```

## 2) Key backend architecture

- **Layered architecture**: Controller → Service → Repository → Entity.
- **Security**: Spring Security + JWT token generation.
- **RBAC**:
  - `/api/admin/**` → ADMIN
  - `/api/staff/**` → STAFF
  - `/api/student/**` → STUDENT
- **Department isolation**: staff queries constrained by staff.department_id.
- **Attendance constraints**:
  - 5 periods/day
  - unique `(student_id, subject_id, date, period)`
  - same-day edit policy enforced at service layer.

## 3) Database schema

- MySQL DDL is in `database/schema.sql`
- Tables implemented per requirement:
  - `users`, `departments`, `students`, `staff`, `subjects`, `attendance`

## 4) Attendance formula

```text
Attendance % = (Present Classes / Total Classes) * 100
```

## 5) REST API design

Complete endpoint list available in `docs/rest-api-endpoints.md`.

## 6) Example snippets already included

- JWT generation: `backend/.../security/JwtService.java`
- Security and role mapping: `backend/.../config/SecurityConfig.java`
- Attendance mark request DTO with validation: `backend/.../dto/AttendanceMarkRequest.java`
- React protected routes: `frontend/src/components/ProtectedRoute.jsx`
- Role-aware routing: `frontend/src/router/AppRouter.jsx`

## 7) PDF reports

This scaffold includes iText dependency and report endpoint placeholders.
Recommended approach:
1. Build report service for class/student/low attendance datasets.
2. Generate PDF via iText and return `application/pdf` response.
3. Reuse same service for Admin/Staff/Student report variants.
