package com.ecommerce.hospitalmanagementservice.entity;

import com.ecommerce.hospitalmanagementservice.enums.DiagnosisStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Diagnosis {

    private String description;

    private LocalDate diagnosedAt;

    private DiagnosisStatus status;
}
