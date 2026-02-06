package com.ecommerce.hospitalmanagementservice.mapper;

import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DoctorResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Doctor;
import org.mapstruct.*;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper {

    @Mapping(target = "department.id", source = "departmentId")
    Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto);

    @Mapping(target = "departmentName", source = "department.name")
    DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor);

    @Mapping(target = "department.id", source = "departmentId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDoctor(DoctorUpdateDto doctorUpdateDto, @MappingTarget Doctor doctor);
}
