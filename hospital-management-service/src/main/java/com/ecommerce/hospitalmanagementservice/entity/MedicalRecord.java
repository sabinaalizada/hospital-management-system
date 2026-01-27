package com.ecommerce.hospitalmanagementservice.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
@Getter
@Setter
public class MedicalRecord {

    @Id
    private UUID id;

    private UUID patientId;

    private List<Visit> visits = new ArrayList<>();
}
