package com.ecommerce.hospitalmanagementservice.service;

import com.ecommerce.hospitalmanagementservice.dto.request.department.DepartmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.department.DepartmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DepartmentResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Department;
import com.ecommerce.hospitalmanagementservice.entity.Doctor;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto addDepartment(DepartmentRequestDto departmentRequestDto);

    List<DepartmentResponseDto> getAllDepartments();

    DepartmentResponseDto updateDepartment(DepartmentUpdateDto departmentUpdateDto, Long id);

    String deleteDepartment(Long id);

    DepartmentResponseDto getDepartmentByName(String departmentName);

    Department getDepartmentById(Long id);
}
