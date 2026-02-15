package com.ecommerce.hospitalmanagementservice.service;

import com.ecommerce.hospitalmanagementservice.dto.request.appointment.AppointmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.appointment.AppointmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.AppointmentResponseDto;
import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;

import java.util.List;

public interface AppointmentService {
    AppointmentResponseDto createAppointment(AppointmentRequestDto appointmentRequestDto);

    AppointmentResponseDto updateAppointment(AppointmentUpdateDto appointmentUpdateDto, Long publicId);

    AppointmentResponseDto updateStatus(AppointmentStatus appointmentStatus, Long publicId);

    AppointmentResponseDto deleteAppointment(Long id);

    AppointmentResponseDto getAppointment(Long id);

    List<AppointmentResponseDto> getAllAppointments();

    List<AppointmentResponseDto> getAppointmentsByPatientId(Long patientId);

    List<AppointmentResponseDto> getAppointmentsByDoctorId(Long doctorId);

    List<AppointmentResponseDto> getTodayAppointments();
}
