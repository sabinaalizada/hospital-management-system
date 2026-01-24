package com.ecommerce.hospitalmanagementservice.entity;

import java.time.LocalDateTime;

public class Doctor {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String specialization;
    private String licenseNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
