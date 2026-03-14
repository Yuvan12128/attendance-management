package com.college.attendance.service.impl;

import com.college.attendance.dto.AttendanceMarkRequest;
import com.college.attendance.entity.Attendance;
import com.college.attendance.entity.Staff;
import com.college.attendance.repository.AttendanceRepository;
import com.college.attendance.repository.StaffRepository;
import com.college.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final StaffRepository staffRepository;

    @Override
    public void markAttendance(Long staffUserId, AttendanceMarkRequest request) {
        Staff staff = staffRepository.findByUserId(staffUserId).orElseThrow();
        request.getRecords().forEach(record -> {
            Attendance attendance = Attendance.builder()
                    .date(request.getDate())
                    .period(request.getPeriod())
                    .status(record.getStatus())
                    .markedBy(staff)
                    .build();
            attendanceRepository.save(attendance);
        });
    }
}
