# REST API Endpoints

## Authentication
- `POST /api/auth/login`

## Admin
- `POST /api/admin/departments`
- `GET /api/admin/departments`
- `POST /api/admin/students`
- `PUT /api/admin/students/{id}`
- `DELETE /api/admin/students/{id}`
- `POST /api/admin/staff`
- `PUT /api/admin/staff/{id}`
- `DELETE /api/admin/staff/{id}`
- `POST /api/admin/subjects`
- `PUT /api/admin/subjects/{id}/assign-staff/{staffId}`
- `GET /api/admin/reports/class-attendance`
- `GET /api/admin/reports/student-attendance/{studentId}`
- `GET /api/admin/reports/low-attendance?threshold=75`
- `GET /api/admin/reports/export/pdf`

## Staff
- `GET /api/staff/classes`
- `GET /api/staff/subjects`
- `POST /api/staff/attendance`
- `PUT /api/staff/attendance/{id}` (same day only)
- `GET /api/staff/reports/class`
- `GET /api/staff/reports/class/export/pdf`

## Student
- `GET /api/student/attendance`
- `GET /api/student/attendance/subject-wise`
- `GET /api/student/attendance/export/pdf`
