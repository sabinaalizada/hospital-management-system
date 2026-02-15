package com.ecommerce.hospitalmanagementservice.dto.request.patient;

import com.ecommerce.hospitalmanagementservice.enums.Gender;
import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import com.ecommerce.hospitalmanagementservice.validation.annotation.PastDate;
import com.ecommerce.hospitalmanagementservice.validation.annotation.PhoneNumber;
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
public class PatientUpdateDto {

    @Size(min = 3, max = 20, message = "Name's length must be min = 3 and max = 20")
    @OnlyLetters
    private String firstName;

    @Size(min = 3, max = 30, message = "Last name's length must be min = 3 and max = 30")
    @OnlyLetters
    private String lastName;

    @PhoneNumber
    private String phone;

    @Size(min = 3, max = 200, message = "Last name's length must be min = 3 and max = 30")
    private String address;

    private Gender gender;

    @PastDate(min = "1900-01-01")
    private LocalDate birthDate;
}
