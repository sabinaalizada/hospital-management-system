package com.ecommerce.hospitalmanagementservice.mapper;

import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.PatientResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Patient;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient patientRequestDtoToPatient(PatientRequestDto patientRequestDto);

    PatientResponseDto patientToPatientResponseDto(Patient patient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Patient patient, PatientUpdateDto patientUpdateDto);
}
