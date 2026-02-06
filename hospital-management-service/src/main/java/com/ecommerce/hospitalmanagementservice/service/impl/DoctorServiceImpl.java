package com.ecommerce.hospitalmanagementservice.service.impl;

import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DoctorResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Department;
import com.ecommerce.hospitalmanagementservice.entity.Doctor;
import com.ecommerce.hospitalmanagementservice.exception.doctor.DoctorAlreadyExistException;
import com.ecommerce.hospitalmanagementservice.exception.doctor.DoctorNotFoundException;
import com.ecommerce.hospitalmanagementservice.mapper.DoctorMapper;
import com.ecommerce.hospitalmanagementservice.repository.DoctorRepo;
import com.ecommerce.hospitalmanagementservice.service.DepartmentService;
import com.ecommerce.hospitalmanagementservice.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepo doctorRepo;
    private final DepartmentService departmentService;

    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {
        Department department = departmentService.getDepartmentById(doctorRequestDto.getDepartmentId());

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
    public DoctorResponseDto updateDoctor(DoctorUpdateDto updateDto, long id) {
        Doctor doctor = getDoctorById(id);

        if (updateDto.getLicenseNumber() != null) {
            if (doctorRepo.existsDoctorByLicenseNumberAndIdNot(updateDto.getLicenseNumber(), id)) {
                throw new DoctorAlreadyExistException("Doctor already exist");
            }
        }

        if (updateDto.getDepartmentId() != null) {
            departmentService.getDepartmentById(updateDto.getDepartmentId());
        }

        doctorMapper.updateDoctor(updateDto, doctor);

        doctorRepo.save(doctor);
        return doctorMapper.doctorToDoctorResponseDto(doctor);
    }

    @Transactional
    @Override
    public String deleteDoctor(long id) {
        Doctor doctor = getDoctorById(id);
        doctorRepo.delete(doctor);
        return "Doctor deleted";
    }

    @Override
    public DoctorResponseDto getDoctor(long id) {
        return doctorMapper.doctorToDoctorResponseDto(getDoctorById(id));
    }

    @Override
    public List<DoctorResponseDto> getDoctors() {
        return doctorRepo
                .findAll()
                .stream()
                .map(doctorMapper::doctorToDoctorResponseDto)
                .toList();
    }

    private Doctor getDoctorById(long id) {
        return doctorRepo.findById(id).orElseThrow(() -> new DoctorNotFoundException("id", id));
    }
}
