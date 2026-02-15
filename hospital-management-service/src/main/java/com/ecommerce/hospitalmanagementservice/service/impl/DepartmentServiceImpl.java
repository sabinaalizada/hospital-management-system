package com.ecommerce.hospitalmanagementservice.service.impl;

import com.ecommerce.hospitalmanagementservice.dto.request.department.DepartmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.department.DepartmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DepartmentResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Department;
import com.ecommerce.hospitalmanagementservice.exception.department.DepartmentAlreadyExistException;
import com.ecommerce.hospitalmanagementservice.exception.department.DepartmentNotFoundException;
import com.ecommerce.hospitalmanagementservice.mapper.DepartmentMapper;
import com.ecommerce.hospitalmanagementservice.repository.DepartmentRepo;
import com.ecommerce.hospitalmanagementservice.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponseDto addDepartment(DepartmentRequestDto departmentRequestDto) {
        Department department = departmentMapper.departmentRequestDtoToDepartment(departmentRequestDto);

        if (departmentRepo.existsByNameIgnoreCase(department.getName())) {
            throw new DepartmentAlreadyExistException(department.getName());
        }

        departmentRepo.save(department);
        return departmentMapper.departmentToDepartmentResponseDto(department);
    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentRepo
                .findAll()
                .stream()
                .map(departmentMapper::departmentToDepartmentResponseDto)
                .collect(Collectors.toList());
    }


    @Transactional
    @Override
    public DepartmentResponseDto updateDepartment(DepartmentUpdateDto departmentUpdateDto, UUID publicId) {
        Department department = getDepartmentByPublicId(publicId);

        if (departmentUpdateDto.getName() != null) {
            if (departmentRepo.existsByNameIgnoreCaseAndIdNot(departmentUpdateDto.getName(), department.getId())) {
                throw new DepartmentAlreadyExistException(departmentUpdateDto.getName());
            }
        }

        departmentMapper.updateDepartment(department, departmentUpdateDto);

        departmentRepo.save(department);
        return departmentMapper.departmentToDepartmentResponseDto(department);
    }

    @Transactional
    @Override
    public void deleteDepartment(UUID publicId) {
        Department department = getDepartmentByPublicId(publicId);
        departmentRepo.delete(department);
    }

    @Override
    public DepartmentResponseDto getDepartmentByName(String departmentName) {
        Department department = departmentRepo
                .findByNameIgnoreCase(departmentName)
                .orElseThrow(() -> new DepartmentNotFoundException("department name", departmentName));
        return departmentMapper.departmentToDepartmentResponseDto(department);
    }

    public Department getDepartmentByPublicId(UUID publicId) {
        return departmentRepo
                .findByPublicId(publicId)
                .orElseThrow(() -> new DepartmentNotFoundException("publicId", publicId));
    }
}
