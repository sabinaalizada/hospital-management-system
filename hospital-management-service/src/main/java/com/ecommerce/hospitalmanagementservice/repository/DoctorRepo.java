package com.ecommerce.hospitalmanagementservice.repository;

import com.ecommerce.hospitalmanagementservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    boolean existsDoctorByLicenseNumberAndIdNot(String licenseNumber,Long id);
    boolean existsDoctorByLicenseNumber(String licenseNumber);
}
