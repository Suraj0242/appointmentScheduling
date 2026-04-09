package com.example.appointmentScheduling.service;



import com.example.appointmentScheduling.dto.PatientDTO;
import com.example.appointmentScheduling.entity.Patient;
import com.example.appointmentScheduling.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientDTO addPatient(PatientDTO patientDTO) {
        Patient patient = Patient.builder()
                .name(patientDTO.getName())
                .age(patientDTO.getAge())
                .gender(patientDTO.getGender())
                .build();
        Patient savedPatient = patientRepository.save(patient);
        return new PatientDTO(savedPatient.getId(), savedPatient.getName(), savedPatient.getAge(), savedPatient.getGender());
    }

    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(p -> new PatientDTO(p.getId(), p.getName(), p.getAge(), p.getGender()))
                .collect(Collectors.toList());
    }
}
