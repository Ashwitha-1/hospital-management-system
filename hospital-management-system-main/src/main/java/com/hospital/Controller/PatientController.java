package com.hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.patient;
import com.hospital.repository.PatientRepository;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*") // Add this to allow frontend access
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @PostMapping
    public patient createPatient(@RequestBody patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/{id}")
    public patient getPatientById(@PathVariable int id) {
        return patientRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public patient updatePatient(@PathVariable int id, @RequestBody patient updatedPatient) {
        patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setAge(updatedPatient.getAge());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setMedicalHistory(updatedPatient.getMedicalHistory());
            return patientRepository.save(existingPatient);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        patientRepository.deleteById(id);
    }
}
