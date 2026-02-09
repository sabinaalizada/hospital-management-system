package com.ecommerce.hospitalmanagementservice.dto.response;

import com.ecommerce.hospitalmanagementservice.enums.Gender;

import java.time.LocalDate;

public record PatientResponseDto(Long id,
                                 String lastName,
                                 String phone,
                                 String address,
                                 Gender gender,
                                 LocalDate birthDate) {
}
