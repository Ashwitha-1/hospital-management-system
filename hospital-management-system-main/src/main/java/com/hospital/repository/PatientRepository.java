package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.model.patient;

@Repository
public interface PatientRepository extends JpaRepository<patient, Integer> {
    // Add custom queries if needed
}
