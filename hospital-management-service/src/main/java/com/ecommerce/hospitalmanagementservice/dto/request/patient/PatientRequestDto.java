package com.ecommerce.hospitalmanagementservice.dto.request.patient;

import com.ecommerce.hospitalmanagementservice.enums.Gender;
import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import com.ecommerce.hospitalmanagementservice.validation.annotation.PastDate;
import com.ecommerce.hospitalmanagementservice.validation.annotation.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDto {

    @NotBlank(message = "Name can not be null or empty")
    @Size(min = 3, max = 20, message = "Name's length must be min = 3 and max = 20")
    @OnlyLetters
    private String firstName;

    @NotBlank(message = "Last name can not be null or empty")
    @Size(min = 3, max = 30, message = "Last name's length must be min = 3 and max = 30")
    @OnlyLetters
    private String lastName;

    @NotBlank(message = "Phone number name can not be null or empty")
    @PhoneNumber
    private String phone;

    @NotBlank(message = "Address can not be null or empty")
    private String address;

    @NotNull(message = "Gender can not be null")
    private Gender gender;

    @NotNull(message = "Birth date can not be null")
    @PastDate(min = "1900-01-01")
    private LocalDate birthDate;
}
