package com.ecommerce.hospitalmanagementservice.service;

import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.PatientResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Patient;

import java.util.List;

public interface PatientService {
    PatientResponseDto addPatient(PatientRequestDto patientRequestDto);
    PatientResponseDto updatePatient(PatientUpdateDto patientUpdateDto, Long id);
    PatientResponseDto getPatientById(Long id);
    List<PatientResponseDto> getAllPatients();
    String deletePatientById(Long id);
    Patient getPatientEntityById(Long id);
}
