package com.college.attendance.repository;

import com.college.attendance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDepartmentIdAndYearAndSection(Long departmentId, Integer year, String section);
}
