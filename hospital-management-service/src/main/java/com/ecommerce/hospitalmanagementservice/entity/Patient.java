package com.ecommerce.hospitalmanagementservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Patient {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
