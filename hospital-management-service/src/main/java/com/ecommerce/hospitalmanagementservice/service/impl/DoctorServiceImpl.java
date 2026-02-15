package com.ecommerce.hospitalmanagementservice.service.impl;

import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DoctorResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Department;
import com.ecommerce.hospitalmanagementservice.entity.Doctor;
import com.ecommerce.hospitalmanagementservice.exception.department.DepartmentNotFoundException;
import com.ecommerce.hospitalmanagementservice.exception.doctor.DoctorAlreadyExistException;
import com.ecommerce.hospitalmanagementservice.exception.doctor.DoctorNotFoundException;
import com.ecommerce.hospitalmanagementservice.mapper.DoctorMapper;
import com.ecommerce.hospitalmanagementservice.repository.DepartmentRepo;
import com.ecommerce.hospitalmanagementservice.repository.DoctorRepo;
import com.ecommerce.hospitalmanagementservice.service.DepartmentService;
import com.ecommerce.hospitalmanagementservice.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepo doctorRepo;
    private final DepartmentRepo departmentRepo;
    private final DepartmentService departmentService;

    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {
        Department department = departmentService.getDepartmentByPublicId(doctorRequestDto.getDepartmentId());
        Doctor doctor = doctorMapper.doctorRequestDtoToDoctor(doctorRequestDto);

        doctor.setDepartment(department);

        if (doctorRepo.existsDoctorByLicenseNumber(doctor.getLicenseNumber())) {
            throw new DoctorAlreadyExistException("Doctor already exist");
        }

        doctorRepo.save(doctor);
        return doctorMapper.doctorToDoctorResponseDto(doctor);
    }

    @Transactional
    @Override
    public DoctorResponseDto updateDoctor(DoctorUpdateDto updateDto, UUID publicId) {
        Doctor doctor = getDoctorById(publicId);

        if (updateDto.getLicenseNumber() != null) {
            if (doctorRepo.existsDoctorByLicenseNumberAndIdNot(updateDto.getLicenseNumber(), doctor.getId())) {
                throw new DoctorAlreadyExistException("Doctor already exist");
            }
        }

        if (updateDto.getDepartmentId() != null) {
            departmentRepo.findById(updateDto.getDepartmentId());
        }

        doctorMapper.updateDoctor(updateDto, doctor);

        doctorRepo.save(doctor);
        return doctorMapper.doctorToDoctorResponseDto(doctor);
    }

    @Transactional
    @Override
    public void deleteDoctor(UUID publicId) {
        Doctor doctor = getDoctorById(publicId);
        doctorRepo.delete(doctor);
    }

    @Override
    public DoctorResponseDto getDoctor(UUID publicId) {
        return doctorMapper.doctorToDoctorResponseDto(getDoctorById(publicId));
    }

    @Override
    public List<DoctorResponseDto> getDoctors() {
        return doctorRepo
                .findAll()
                .stream()
                .map(doctorMapper::doctorToDoctorResponseDto)
                .toList();
    }

    public Doctor getDoctorById(UUID publicId) {
        return doctorRepo.findByPublicId(publicId).orElseThrow(() -> new DoctorNotFoundException("publicId", publicId));
    }
}
