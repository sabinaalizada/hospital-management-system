package com.ecommerce.hospitalmanagementservice.service.impl;

import com.ecommerce.hospitalmanagementservice.dto.request.appointment.AppointmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.appointment.AppointmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.AppointmentResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Doctor;
import com.ecommerce.hospitalmanagementservice.entity.Patient;
import com.ecommerce.hospitalmanagementservice.enums.AppointmentStatus;
import com.ecommerce.hospitalmanagementservice.mapper.AppointmentMapper;
import com.ecommerce.hospitalmanagementservice.repository.AppointmentRepo;
import com.ecommerce.hospitalmanagementservice.service.AppointmentService;
import com.ecommerce.hospitalmanagementservice.service.DoctorService;
import com.ecommerce.hospitalmanagementservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private PatientService patientService;
    private DoctorService doctorService;
    private AppointmentRepo appointmentRepo;
    private AppointmentMapper appointmentMapper;

    @Override
    public AppointmentResponseDto createAppointment(AppointmentRequestDto appointmentRequestDto) {
        Patient patient = patientService.getPatientEntityById(appointmentRequestDto.getPatientId());
        Doctor doctor = doctorService.getDoctorById(appointmentRequestDto.getDoctorId());


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
