package com.ecommerce.hospitalmanagementservice.mapper;

import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.doctor.DoctorUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.DoctorResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Doctor;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto);

    DoctorResponseDto doctorToDoctorResponseDto(Doctor doctor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateDoctor(DoctorUpdateDto doctorUpdateDto, @MappingTarget Doctor doctor);
}
