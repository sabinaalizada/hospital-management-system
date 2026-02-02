package com.ecommerce.hospitalmanagementservice.service;

import com.ecommerce.hospitalmanagementservice.dto.request.DepartmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.DepartmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto addDepartment(DepartmentRequestDto departmentRequestDto);
    List<DepartmentResponseDto> getAllDepartments();
    DepartmentResponseDto updateDepartment(DepartmentUpdateDto departmentUpdateDto, Long id);
    String deleteDepartment(Long id);
    DepartmentResponseDto getDepartmentByName(String departmentName);
}
