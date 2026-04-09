package com.example.appointmentScheduling.dto;




import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDTO {
    private Long id;
    private String name;
    private String specialization;
}