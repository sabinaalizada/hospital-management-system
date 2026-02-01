package com.ecommerce.hospitalmanagementservice.service.impl;

import com.ecommerce.hospitalmanagementservice.dto.request.DepartmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DepartmentResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Department;
import com.ecommerce.hospitalmanagementservice.mapper.DepartmentMapper;
import com.ecommerce.hospitalmanagementservice.repository.DepartmentRepo;
import com.ecommerce.hospitalmanagementservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponseDto addDepartment(DepartmentRequestDto departmentRequestDto) {
        Department department = departmentMapper.departmentRequestDtoToDepartment(departmentRequestDto);
        String departmentName = department.getName().toUpperCase().trim();
        if (departmentRepo.existsByNameIgnoreCase(departmentName)) {
            throw new RuntimeException("Department already exists");
        }
        department.setName(departmentName);
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


    @Override
    public DepartmentResponseDto updateDepartment(DepartmentRequestDto departmentRequestDto, Long id) {
        Department department = getDepartmentById(id);

        String departmentName = departmentRequestDto.getName().toUpperCase().trim();
        if (departmentRepo.existsByNameIgnoreCaseAndIdNot(departmentName, id)) {
            throw new RuntimeException("Department already exists");
        }

        departmentMapper.updateDepartment(department, departmentRequestDto);
        department.setName(departmentName);
        departmentRepo.save(department);
        return departmentMapper.departmentToDepartmentResponseDto(department);
    }

    @Override
    public String deleteDepartment(Long id) {
        Department department = getDepartmentById(id);
        departmentRepo.delete(department);
        return "Department deleted successfully";
    }

    @Override
    public DepartmentResponseDto getDepartmentByName(String departmentName) {
        Department department = departmentRepo
                .findByName(departmentName)
                .orElseThrow();
        return departmentMapper.departmentToDepartmentResponseDto(department);
    }

    private Department getDepartmentById(Long id) {
        return departmentRepo
                .findById(id)
                .orElseThrow();
    }
}
