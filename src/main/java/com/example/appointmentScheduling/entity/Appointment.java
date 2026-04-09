package com.example.appointmentScheduling.entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;



    public Appointment(LocalDate appointmentDate, Doctor doctor, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.patient = patient;
    }


}