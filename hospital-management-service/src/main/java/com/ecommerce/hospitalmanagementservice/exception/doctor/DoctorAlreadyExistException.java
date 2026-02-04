package com.ecommerce.hospitalmanagementservice.exception.doctor;

public class DoctorAlreadyExistException extends RuntimeException{
    public DoctorAlreadyExistException(String message) {
        super(message);
    }
}
