package com.ecommerce.hospitalmanagementservice.dto.request.doctor;

import com.ecommerce.hospitalmanagementservice.validation.annotation.DoctorLicenseNumber;
import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import com.ecommerce.hospitalmanagementservice.validation.annotation.PhoneNumber;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateDto {

    @Size(min = 3, max = 20, message = "Name's length must be min = 3 and max = 100")
    @OnlyLetters
    private String firstName;

    @Size(min = 3, max = 30, message = "Last name's length must be min = 3 and max = 30")
    @OnlyLetters
    private String lastName;

    @PhoneNumber
    private String phone;

    @Size(min = 3, max = 50, message = "Last name's length must be min = 3 and max = 50")
    @OnlyLetters
    private String specialization;

    @DoctorLicenseNumber
    private String licenseNumber;

    private Long departmentId;
}
