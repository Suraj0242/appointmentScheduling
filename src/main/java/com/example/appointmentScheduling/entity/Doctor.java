package com.example.appointmentScheduling.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialization;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }


}