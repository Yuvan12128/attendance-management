package com.college.attendance.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @PostMapping("/departments")
    public String createDepartment() { return "Department created"; }

    @GetMapping("/reports/low-attendance")
    public String lowAttendanceReport() { return "Low attendance <75%"; }
}
