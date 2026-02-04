package com.ecommerce.hospitalmanagementservice.service;

import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DoctorResponseDto;

import java.util.List;

public interface DoctorService {
    DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto);

    DoctorResponseDto updateDoctor(DoctorUpdateDto updateDto, long id);

    String deleteDoctor(long id);

    DoctorResponseDto getDoctor(long id);

    List<DoctorResponseDto> getDoctors();
}
