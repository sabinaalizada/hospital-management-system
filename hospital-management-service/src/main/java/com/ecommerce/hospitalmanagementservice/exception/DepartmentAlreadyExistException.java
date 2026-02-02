package com.ecommerce.hospitalmanagementservice.exception;

import lombok.Getter;

@Getter
public class DepartmentAlreadyExistException extends RuntimeException {

    private final String departmentName;

    public DepartmentAlreadyExistException(String departmentName) {
        super("Department with name " + departmentName + " already exist");
        this.departmentName = departmentName;
    }
}
