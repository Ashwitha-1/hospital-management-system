package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    // Optional: custom queries can go here later
}
