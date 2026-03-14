CREATE TABLE departments (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(120) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role ENUM('ADMIN','STAFF','STUDENT') NOT NULL
);

CREATE TABLE staff (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  employee_code VARCHAR(50) NOT NULL,
  full_name VARCHAR(120) NOT NULL,
  department_id BIGINT NOT NULL,
  user_id BIGINT UNIQUE NOT NULL,
  FOREIGN KEY (department_id) REFERENCES departments(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE students (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  roll_no VARCHAR(50) NOT NULL,
  full_name VARCHAR(120) NOT NULL,
  department_id BIGINT NOT NULL,
  year INT NOT NULL,
  section VARCHAR(10) NOT NULL,
  user_id BIGINT UNIQUE NOT NULL,
  FOREIGN KEY (department_id) REFERENCES departments(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE subjects (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  code VARCHAR(30) NOT NULL,
  name VARCHAR(120) NOT NULL,
  department_id BIGINT NOT NULL,
  year INT NOT NULL,
  staff_id BIGINT NOT NULL,
  FOREIGN KEY (department_id) REFERENCES departments(id),
  FOREIGN KEY (staff_id) REFERENCES staff(id)
);

CREATE TABLE attendance (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  student_id BIGINT NOT NULL,
  subject_id BIGINT NOT NULL,
  date DATE NOT NULL,
  period INT NOT NULL CHECK (period BETWEEN 1 AND 5),
  status CHAR(1) NOT NULL CHECK (status IN ('P','A')),
  marked_by BIGINT NOT NULL,
  UNIQUE KEY uk_attendance (student_id, subject_id, date, period),
  FOREIGN KEY (student_id) REFERENCES students(id),
  FOREIGN KEY (subject_id) REFERENCES subjects(id),
  FOREIGN KEY (marked_by) REFERENCES staff(id)
);
