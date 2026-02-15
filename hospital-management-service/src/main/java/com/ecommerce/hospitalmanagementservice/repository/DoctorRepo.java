package com.ecommerce.hospitalmanagementservice.repository;

import com.ecommerce.hospitalmanagementservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    boolean existsDoctorByLicenseNumberAndIdNot(String licenseNumber,Long id);
    boolean existsDoctorByLicenseNumber(String licenseNumber);

    Optional<Doctor> findByPublicId(UUID publicId);
}
