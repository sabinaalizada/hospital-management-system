package com.ecommerce.hospitalmanagementservice.repository;

import com.ecommerce.hospitalmanagementservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
