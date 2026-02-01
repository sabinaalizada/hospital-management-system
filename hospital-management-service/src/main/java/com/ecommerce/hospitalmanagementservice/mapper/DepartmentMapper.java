package com.ecommerce.hospitalmanagementservice.mapper;

import com.ecommerce.hospitalmanagementservice.dto.request.DepartmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DepartmentResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentResponseDto departmentToDepartmentResponseDto(Department department);

    Department departmentRequestDtoToDepartment(DepartmentRequestDto departmentRequestDto);

    void updateDepartment(@MappingTarget Department department, DepartmentRequestDto departmentRequestDto);
}
