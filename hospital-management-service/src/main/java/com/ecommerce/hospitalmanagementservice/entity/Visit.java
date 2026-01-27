package com.ecommerce.hospitalmanagementservice.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Visit {

    private LocalDateTime dateTime;

    private UUID doctorId;

    private List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
}
