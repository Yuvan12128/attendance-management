package com.college.attendance.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AttendanceMarkRequest {
    @NotNull private Long subjectId;
    @NotNull private Long departmentId;
    @NotNull @Min(1) @Max(4) private Integer year;
    @NotBlank private String section;
    @NotNull private LocalDate date;
    @NotNull @Min(1) @Max(5) private Integer period;
    @NotEmpty private List<StudentAttendanceDto> records;

    @Data
    public static class StudentAttendanceDto {
        @NotNull private Long studentId;
        @Pattern(regexp = "P|A")
        private String status;
    }
}
