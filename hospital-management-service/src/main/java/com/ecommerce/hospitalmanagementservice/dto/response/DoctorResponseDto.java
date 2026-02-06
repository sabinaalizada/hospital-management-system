package com.ecommerce.hospitalmanagementservice.dto.response;


public record DoctorResponseDto(Long id,
                                String departmentName,
                                String firstName,
                                String lastName,
                                String phone,
                                String specialization,
                                String licenseNumber) {
}

