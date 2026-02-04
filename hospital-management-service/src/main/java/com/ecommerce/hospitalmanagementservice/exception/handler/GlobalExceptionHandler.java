package com.ecommerce.hospitalmanagementservice.exception.handler;

import com.ecommerce.hospitalmanagementservice.exception.department.DepartmentAlreadyExistException;
import com.ecommerce.hospitalmanagementservice.exception.department.DepartmentNotFoundException;
import com.ecommerce.hospitalmanagementservice.exception.doctor.DoctorAlreadyExistException;
import com.ecommerce.hospitalmanagementservice.exception.doctor.DoctorNotFoundException;
import com.ecommerce.hospitalmanagementservice.exception.model.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> departmentNotFound(DepartmentNotFoundException exception) {

        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .type("errors/department-not-found")
                .title("Department Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);

    }

    @ExceptionHandler(DepartmentAlreadyExistException.class)
    public ResponseEntity<CustomErrorResponse> departmentAlreadyExistException(DepartmentAlreadyExistException exception) {

        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .type("errors/department-already-exist")
                .title("Department Already Exist")
                .status(HttpStatus.BAD_REQUEST.value())
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);

    }

    @ExceptionHandler(DoctorAlreadyExistException.class)
    public ResponseEntity<CustomErrorResponse> doctorAlreadyExistException(DoctorAlreadyExistException exception) {

        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .type("errors/doctor-already-exist")
                .title("Doctor Already Exist")
                .status(HttpStatus.BAD_REQUEST.value())
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);

    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> doctorNotFound(DoctorNotFoundException exception) {

        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .type("errors/doctor-not-found")
                .title("Doctor Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleValidationExceptions(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .type("errors/method-argument-not-valid-exception")
                .title("Validation Failed")
                .status(HttpStatus.BAD_REQUEST.value())
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> exception(Exception exception) {

        CustomErrorResponse errorResponse = CustomErrorResponse.builder()
                .type("errors/internal-server-error")
                .title("INTERNAL_SERVER_ERROR")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
}
