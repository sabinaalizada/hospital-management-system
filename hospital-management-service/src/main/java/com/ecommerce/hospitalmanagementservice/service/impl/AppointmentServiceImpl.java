package com.ecommerce.hospitalmanagementservice.service.impl;

import com.ecommerce.hospitalmanagementservice.dto.request.appointment.AppointmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.appointment.AppointmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.AppointmentResponseDto;
import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;
import com.ecommerce.hospitalmanagementservice.service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public AppointmentResponseDto createAppointment(AppointmentRequestDto appointmentRequestDto) {
        return null;
    }

    @Override
    public AppointmentResponseDto updateAppointment(AppointmentUpdateDto appointmentUpdateDto, Long publicId) {
        return null;
    }

    @Override
    public AppointmentResponseDto updateStatus(AppointmentStatus appointmentStatus, Long publicId) {
        return null;
    }

    @Override
    public AppointmentResponseDto deleteAppointment(Long id) {
        return null;
    }

    @Override
    public AppointmentResponseDto getAppointment(Long id) {
        return null;
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointments() {
        return List.of();
    }

    @Override
    public List<AppointmentResponseDto> getAppointmentsByPatientId(Long patientId) {
        return List.of();
    }

    @Override
    public List<AppointmentResponseDto> getAppointmentsByDoctorId(Long doctorId) {
        return List.of();
    }

    @Override
    public List<AppointmentResponseDto> getTodayAppointments() {
        return List.of();
    }
}
