package com.example.appointmentScheduling.controller;



import com.example.appointmentScheduling.dto.DoctorDTO;
import com.example.appointmentScheduling.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public DoctorDTO addDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.addDoctor(doctorDTO);
    }

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
}
