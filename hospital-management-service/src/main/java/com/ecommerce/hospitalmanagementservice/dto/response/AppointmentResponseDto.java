package com.ecommerce.hospitalmanagementservice.dto.response;


import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;


import java.time.ZonedDateTime;

public record AppointmentResponseDto(Long id,
                                     String reason,
                                     ZonedDateTime appointmentTime,
                                     AppointmentStatus appointmentStatus,
                                     Long patientId,
                                     Long doctorId) {
}
