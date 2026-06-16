package com.hospital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AppointmentRequest;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.patient;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentRequest request) {
        try {
            System.out.println("Incoming appointment request: " + request);

            // Validate input
            if (request.getDoctorId() == null || request.getPatientId() == null ||
                request.getDate() == null || request.getTime() == null) {
                return ResponseEntity.badRequest().body("Doctor ID, Patient ID, date, and time must not be null");
            }

            // Check doctor and patient exist
            Doctor doctor = doctorRepository.findById(request.getDoctorId()).orElse(null);
            if (doctor == null) {
                return ResponseEntity.badRequest().body("Doctor not found with ID: " + request.getDoctorId());
            }

            patient patient = patientRepository.findById(request.getPatientId()).orElse(null);
            if (patient == null) {
                return ResponseEntity.badRequest().body("Patient not found with ID: " + request.getPatientId());
            }

            // Create appointment
            Appointment appointment = new Appointment();
            appointment.setDate(request.getDate());
            appointment.setTime(request.getTime());
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);

            // Save
            appointmentRepository.save(appointment);

            return ResponseEntity.ok("Appointment booked successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // Log the stack trace
            return ResponseEntity.status(500).body("Failed to book appointment: " + e.getMessage());
        }
    }
}
