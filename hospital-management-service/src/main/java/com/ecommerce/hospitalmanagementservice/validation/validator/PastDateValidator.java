package com.ecommerce.hospitalmanagementservice.validation.validator;

import com.ecommerce.hospitalmanagementservice.validation.annotation.PastDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PastDateValidator implements ConstraintValidator<PastDate, LocalDate> {

    private LocalDate minDate;

    @Override
    public void initialize(PastDate constraintAnnotation) {
        minDate = LocalDate.parse(constraintAnnotation.min());
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate == null) return false;
        return localDate.isAfter(minDate) && localDate.isBefore(LocalDate.now());
    }
}
