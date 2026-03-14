package com.college.attendance.service;

import com.college.attendance.dto.AttendanceMarkRequest;

public interface AttendanceService {
    void markAttendance(Long staffUserId, AttendanceMarkRequest request);
}
