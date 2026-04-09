package com.example.appointmentScheduling.service;



import com.example.appointmentScheduling.dto.DoctorDTO;
import com.example.appointmentScheduling.entity.Doctor;
import com.example.appointmentScheduling.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorDTO addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = Doctor.builder()
                .name(doctorDTO.getName())
                .specialization(doctorDTO.getSpecialization())
                .build();
        Doctor savedDoctor = doctorRepository.save(doctor);
        return new DoctorDTO(savedDoctor.getId(), savedDoctor.getName(), savedDoctor.getSpecialization());
    }

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(d -> new DoctorDTO(d.getId(), d.getName(), d.getSpecialization()))
                .collect(Collectors.toList());
    }
}
