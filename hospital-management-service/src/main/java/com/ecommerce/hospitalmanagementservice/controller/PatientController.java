package com.ecommerce.hospitalmanagementservice.controller;

import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.PatientResponseDto;
import com.ecommerce.hospitalmanagementservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patient) {
        PatientResponseDto savedPatient = patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients() {
        List<PatientResponseDto> patients = patientService.getAllPatients();
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }

    @GetMapping("/{publicId}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable UUID publicId) {
        PatientResponseDto patient = patientService.getPatientById(publicId);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @PatchMapping("/{publicId}")
    public ResponseEntity<PatientResponseDto> updatePatient(
            @PathVariable UUID publicId,
            @Valid @RequestBody PatientUpdateDto patientUpdateDto) {

        PatientResponseDto updatedPatient = patientService.updatePatient(patientUpdateDto, publicId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPatient);
    }

    @DeleteMapping("/{publicId}")
    public ResponseEntity<String> deletePatient(@PathVariable UUID publicId) {
        String response = patientService.deletePatientById(publicId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

}
