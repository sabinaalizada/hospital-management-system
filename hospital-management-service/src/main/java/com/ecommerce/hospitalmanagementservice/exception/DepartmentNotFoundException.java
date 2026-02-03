package com.ecommerce.hospitalmanagementservice.exception;

import lombok.Getter;

@Getter
public class DepartmentNotFoundException extends RuntimeException {

    private final String parameterName;
    private final Object parameterValue;

    public DepartmentNotFoundException(String parameterName, Object parameterValue) {
        super("Department with " + parameterName + " " + parameterValue + " not found");
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }
}
