package com.ecommerce.hospitalmanagementservice.mapper;

import com.ecommerce.hospitalmanagementservice.dto.request.department.DepartmentRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.department.DepartmentUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DepartmentResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Department;
import org.mapstruct.*;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    DepartmentResponseDto departmentToDepartmentResponseDto(Department department);

    @Mapping(target = "description", expression = "java(trim(departmentRequestDto.getDescription()))")
    Department departmentRequestDtoToDepartment(DepartmentRequestDto departmentRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDepartment(@MappingTarget Department department, DepartmentUpdateDto departmentUpdateDto);

    @BeforeMapping
    default void trimUpdateDto(DepartmentUpdateDto dto) {
        if (dto.getDescription() != null) {
            dto.setDescription(dto.getDescription().trim());
        }
    }

    default String trim(String value){
        return value == null ? null : value.trim();
    }

}
