package com.ecommerce.hospitalmanagementservice.dto.request.appointment;

import com.ecommerce.hospitalmanagementservice.validation.annotation.FutureDate;
import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateDto {
    @Size(min = 3, max = 150, message = "Reason's length must be min = 3 and max = 150")
    @OnlyLetters
    private String reason;

    @FutureDate(year = 1)
    private ZonedDateTime appointmentTime;

    private Long patientId;

    private Long doctorId;
}
