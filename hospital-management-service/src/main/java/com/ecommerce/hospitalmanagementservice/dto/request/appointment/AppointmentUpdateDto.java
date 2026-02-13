package com.ecommerce.hospitalmanagementservice.dto.request.appointment;

import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;
import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AppointmentUpdateDto {
    @Size(min = 3, max = 150, message = "Reason's length must be min = 3 and max = 150")
    @OnlyLetters
    private String reason;

    private LocalDate appointmentTime;

    private AppointmentStatus appointmentStatus;

    private Long patientId;

    private Long doctorId;
}
