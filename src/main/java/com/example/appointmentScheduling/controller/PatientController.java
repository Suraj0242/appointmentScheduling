package com.example.appointmentScheduling.controller;



import com.example.appointmentScheduling.dto.PatientDTO;
import com.example.appointmentScheduling.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public PatientDTO addPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.addPatient(patientDTO);
    }

    @GetMapping
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }
}
