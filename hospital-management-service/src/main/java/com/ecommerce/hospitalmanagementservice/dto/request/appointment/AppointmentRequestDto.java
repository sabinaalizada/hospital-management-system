package com.ecommerce.hospitalmanagementservice.dto.request.appointment;

import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;
import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AppointmentRequestDto {

    @NotBlank(message = "Reason can not be null or empty")
    @Size(min = 3, max = 150, message = "Reason's length must be min = 3 and max = 150")
    @OnlyLetters
    private String reason;

    @NotBlank(message = "Appointment time can not be null or empty")
    private LocalDate appointmentTime;

    @NotBlank(message = "Appointment status can not be null or empty")
    private AppointmentStatus appointmentStatus;

    @NotBlank(message = "Patient id can not be null or empty")
    private Long patientId;

    @NotBlank(message = "Doctor id can not be null or empty")
    private Long doctorId;
}
