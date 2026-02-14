package com.ecommerce.hospitalmanagementservice.dto.request.appointment;

import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;
import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AppointmentRequestDto {

    @NotBlank(message = "Reason can not be null or empty")
    @Size(min = 3, max = 150, message = "Reason's length must be min = 3 and max = 150")
    @OnlyLetters
    private String reason;

    @NotNull(message = "Appointment time can not be null")
    @Future(message = "Appointment time must be in the future")
    private LocalDate appointmentTime;

    @NotBlank(message = "Appointment status can not be null or empty")
    private AppointmentStatus appointmentStatus;

    @NotNull(message = "Patient id can not be null")
    private Long patientId;

    @NotNull(message = "Doctor id can not be null")
    private Long doctorId;
}
