package com.ecommerce.hospitalmanagementservice.exception.doctor;

import lombok.Getter;

@Getter
public class DoctorNotFoundException extends RuntimeException{

    private final String parameterName;
    private final Object parameterValue;

    public DoctorNotFoundException(String parameterName, Object parameterValue) {
        super("Doctor with " + parameterName + " " + parameterValue + " not found");
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }
}
