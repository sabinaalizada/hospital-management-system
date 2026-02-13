package com.ecommerce.hospitalmanagementservice.dto.response;


import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;

import java.time.LocalDate;

public record AppointmentResponseDto(Long id,
                                     String reason,
                                     LocalDate appointmentTime,
                                     AppointmentStatus appointmentStatus,
                                     Long patientId,
                                     Long doctorId) {
}
