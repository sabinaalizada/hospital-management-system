package com.ecommerce.hospitalmanagementservice.dto.request.doctor;

import com.ecommerce.hospitalmanagementservice.validation.annotation.DoctorLicenseNumber;
import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import com.ecommerce.hospitalmanagementservice.validation.annotation.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequestDto {

    @NotBlank(message = "Name can not be null or empty")
    @Size(min = 3, max = 20, message = "Name's length must be min = 3 and max = 20")
    @OnlyLetters
    private String firstName;

    @NotBlank(message = "Last name can not be null or empty")
    @Size(min = 3, max = 30, message = "Last name's length must be min = 3 and max = 30")
    @OnlyLetters
    private String lastName;

    @NotBlank(message = "License number name can not be null or empty")
    @PhoneNumber
    private String phone;

    @NotBlank(message = "Specialization name can not be null or empty")
    @Size(min = 3, max = 30, message = "Last name's length must be min = 3 and max = 30")
    @OnlyLetters
    private String specialization;

    @NotBlank(message = "License number name can not be null or empty")
    @DoctorLicenseNumber
    private String licenseNumber;

    @NotNull(message = "Department id can not be null")
    private UUID departmentId;
}
