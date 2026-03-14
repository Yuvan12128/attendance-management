package com.college.attendance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "attendance",
    uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "subject_id", "date", "period"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Attendance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = false) @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Integer period; // 1..5

    @Column(nullable = false, length = 1)
    private String status; // P or A

    @ManyToOne(optional = false) @JoinColumn(name = "marked_by")
    private Staff markedBy;
}
