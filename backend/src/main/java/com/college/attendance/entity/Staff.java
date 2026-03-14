package com.college.attendance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "staff")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Staff {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employeeCode;

    @Column(nullable = false)
    private String fullName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
