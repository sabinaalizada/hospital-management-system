package com.ecommerce.hospitalmanagementservice.exception.handler;

import com.ecommerce.hospitalmanagementservice.exception.DepartmentAlreadyExistException;
import com.ecommerce.hospitalmanagementservice.exception.DepartmentNotFoundException;
import com.ecommerce.hospitalmanagementservice.exception.model.CustomErrorResponse;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorResponse departmentNotFound(DepartmentNotFoundException exception) {

        return CustomErrorResponse.builder()
                .type("errors/department-not-found")
                .title("Department Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();


    }

    @ExceptionHandler(DepartmentAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomErrorResponse departmentAlreadyExistException(DepartmentAlreadyExistException exception) {

        return CustomErrorResponse.builder()
                .type("errors/department-already-exist")
                .title("Department Already Exist")
                .status(HttpStatus.BAD_REQUEST.value())
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomErrorResponse exception(Exception exception) {

        return CustomErrorResponse.builder()
                .type("errors/internal-server-error")
                .title("INTERNAL_SERVER_ERROR")
                .status(HttpStatus.BAD_REQUEST.value())
                .detail(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
