package com.ecommerce.hospitalmanagementservice.repository;

import com.ecommerce.hospitalmanagementservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Optional<Patient> findByPublicId(UUID publicId);
}
