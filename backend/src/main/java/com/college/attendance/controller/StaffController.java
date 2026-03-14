package com.college.attendance.controller;

import com.college.attendance.dto.AttendanceMarkRequest;
import com.college.attendance.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {
    private final AttendanceService attendanceService;

    @PostMapping("/attendance")
    public ResponseEntity<Void> markAttendance(@Valid @RequestBody AttendanceMarkRequest request) {
        attendanceService.markAttendance(1L, request);
        return ResponseEntity.ok().build();
    }
}
