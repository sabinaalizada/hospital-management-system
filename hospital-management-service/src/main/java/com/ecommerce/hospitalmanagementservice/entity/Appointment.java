package com.ecommerce.hospitalmanagementservice.entity;

import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;

import java.time.LocalDateTime;

public class Appointment {
    private long id;
    private String reason;
    private LocalDateTime appointmentTime;
    private AppointmentStatus appointmentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
