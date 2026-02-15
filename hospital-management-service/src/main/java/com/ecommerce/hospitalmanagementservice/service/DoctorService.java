package com.ecommerce.hospitalmanagementservice.service;

import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DoctorResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Doctor;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto);

    DoctorResponseDto updateDoctor(DoctorUpdateDto updateDto, UUID publicId);

    void deleteDoctor(UUID publicId);

    DoctorResponseDto getDoctor(UUID publicId);

    Doctor getDoctorById(UUID publicId);

    List<DoctorResponseDto> getDoctors();
}
