package com.ecommerce.hospitalmanagementservice.mapper;

import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientRequestDto;
import com.ecommerce.hospitalmanagementservice.dto.request.patient.PatientUpdateDto;
import com.ecommerce.hospitalmanagementservice.dto.response.PatientResponseDto;
import com.ecommerce.hospitalmanagementservice.entity.Patient;
import org.mapstruct.*;

import java.time.LocalDate;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {

    @Mapping(target = "birthDate", expression = "java(trimDate(patientRequestDto.getBirthDate()))")
    Patient patientRequestDtoToPatient(PatientRequestDto patientRequestDto);

    PatientResponseDto patientToPatientResponseDto(Patient patient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "birthDate", expression = "java(trimDate(patientUpdateDto.getBirthDate()))")
    void update(@MappingTarget Patient patient, PatientUpdateDto patientUpdateDto);

    default LocalDate trimDate(LocalDate date) {
        return date == null ? null : LocalDate.parse(date.toString().trim());
    }
}
