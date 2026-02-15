package com.ecommerce.hospitalmanagementservice.service;

import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.PatientResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    PatientResponseDto addPatient(PatientRequestDto patientRequestDto);

    PatientResponseDto updatePatient(PatientUpdateDto patientUpdateDto, UUID publicId);

    PatientResponseDto getPatientById(UUID publicId);

    List<PatientResponseDto> getAllPatients();

    String deletePatientById(UUID publicId);

    Patient getPatientEntityById(UUID publicId);
}
