package com.example.appointmentScheduling.dto;



import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO {
    private Long id;
    private LocalDate appointmentDate;
    private Long doctorId;
    private Long patientId;
}