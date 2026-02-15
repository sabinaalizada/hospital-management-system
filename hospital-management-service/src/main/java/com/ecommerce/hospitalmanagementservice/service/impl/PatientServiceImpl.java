package com.ecommerce.hospitalmanagementservice.service.impl;

import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.PatientResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Patient;
import com.ecommerce.hospitalmanagementservice.mapper.PatientMapper;
import com.ecommerce.hospitalmanagementservice.repository.PatientRepo;
import com.ecommerce.hospitalmanagementservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;
    private final PatientMapper patientMapper;

    @Override
    public PatientResponseDto addPatient(PatientRequestDto patientRequestDto) {
        Patient patient = patientMapper.patientRequestDtoToPatient(patientRequestDto);
        patientRepo.save(patient);
        return patientMapper.patientToPatientResponseDto(patient);
    }

    @Override
    public PatientResponseDto updatePatient(PatientUpdateDto patientUpdateDto, UUID publicId) {
        Patient patient = getPatientEntityById(publicId);
        patientMapper.update(patient, patientUpdateDto);
        patientRepo.save(patient);
        return patientMapper.patientToPatientResponseDto(patient);
    }

    @Override
    public PatientResponseDto getPatientById(UUID publicId) {
        return patientMapper.patientToPatientResponseDto(getPatientEntityById(publicId));
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        return patientRepo
                .findAll()
                .stream()
                .map(patientMapper::patientToPatientResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePatientById(UUID publicId) {
        Patient patient = getPatientEntityById(publicId);
        patientRepo.delete(patient);
    }

    @Override
    public Patient getPatientEntityById(UUID publicId) {
        return patientRepo.findByPublicId(publicId).orElse(null);
    }
}
