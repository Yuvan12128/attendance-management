package com.college.attendance.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @GetMapping("/attendance/summary")
    public String summary() {
        return "Present/Total * 100";
    }
}
