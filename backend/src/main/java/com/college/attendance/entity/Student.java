package com.college.attendance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rollNo;

    @Column(nullable = false)
    private String fullName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String section;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
