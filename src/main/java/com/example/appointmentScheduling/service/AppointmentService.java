package com.example.appointmentScheduling.service;



import com.example.appointmentScheduling.dto.AppointmentDTO;
import com.example.appointmentScheduling.entity.Appointment;
import com.example.appointmentScheduling.entity.Doctor;
import com.example.appointmentScheduling.entity.Patient;
import com.example.appointmentScheduling.repository.AppointmentRepository;
import com.example.appointmentScheduling.repository.DoctorRepository;
import com.example.appointmentScheduling.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO) {
        Doctor doctor = doctorRepository.findById(appointmentDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Enforce 10 patients/day rule
        List<Appointment> appointments = appointmentRepository
                .findByDoctorIdAndAppointmentDate(doctor.getId(), appointmentDTO.getAppointmentDate());

        if (appointments.size() >= 10) {
            throw new RuntimeException("Doctor already has 10 appointments for this day");
        }

        Appointment appointment = Appointment.builder()
                .appointmentDate(appointmentDTO.getAppointmentDate())
                .doctor(doctor)
                .patient(patient)
                .build();

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return new AppointmentDTO(savedAppointment.getId(),
                savedAppointment.getAppointmentDate(),
                savedAppointment.getDoctor().getId(),
                savedAppointment.getPatient().getId());
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(a -> new AppointmentDTO(a.getId(), a.getAppointmentDate(),
                        a.getDoctor().getId(), a.getPatient().getId()))
                .collect(Collectors.toList());
    }
}
