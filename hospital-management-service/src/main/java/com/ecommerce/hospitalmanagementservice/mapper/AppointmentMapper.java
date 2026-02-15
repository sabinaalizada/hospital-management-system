package com.ecommerce.hospitalmanagementservice.mapper;

import com.ecommerce.hospitalmanagementservice.dto.request.appointment.AppointmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.AppointmentResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppointmentMapper {
    AppointmentResponseDto toAppointmentResponseDto(Appointment appointment);

    Appointment toAppointment(AppointmentResponseDto appointmentResponseDto);

    void updateAppointment(Appointment appointment, AppointmentUpdateDto appointmentUpdateDto);
}
