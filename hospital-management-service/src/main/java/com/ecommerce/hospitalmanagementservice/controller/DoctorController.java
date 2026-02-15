package com.ecommerce.hospitalmanagementservice.controller;

import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DoctorResponseDto;
import com.ecommerce.hospitalmanagementservice.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorResponseDto> createDoctor(@Valid @RequestBody DoctorRequestDto doctorRequestDto) {
        DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorResponseDto);
    }

    @PatchMapping("/{publicId}")
    public ResponseEntity<DoctorResponseDto> updateDoctor(
            @Valid @RequestBody DoctorUpdateDto updateDto,
            @PathVariable UUID publicId) {
        DoctorResponseDto doctorResponseDto = doctorService.updateDoctor(updateDto,publicId);
        return ResponseEntity.status(HttpStatus.OK).body(doctorResponseDto);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors() {
        List<DoctorResponseDto> responseDtos = doctorService.getDoctors();
        return ResponseEntity.status(HttpStatus.OK).body(responseDtos);
    }

    @GetMapping("/{publicId}")
    public ResponseEntity<DoctorResponseDto> getDoctorById(@PathVariable UUID publicId) {
        DoctorResponseDto doctorResponseDto = doctorService.getDoctor(publicId);
        return ResponseEntity.status(HttpStatus.OK).body(doctorResponseDto);
    }

    @DeleteMapping("/{publicId}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable UUID publicId) {
        doctorService.deleteDoctor(publicId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
