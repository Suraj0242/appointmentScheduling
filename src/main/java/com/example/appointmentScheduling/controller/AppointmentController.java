package com.example.appointmentScheduling.controller;


import com.example.appointmentScheduling.dto.AppointmentDTO;
import com.example.appointmentScheduling.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO bookAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return appointmentService.bookAppointment(appointmentDTO);
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
}