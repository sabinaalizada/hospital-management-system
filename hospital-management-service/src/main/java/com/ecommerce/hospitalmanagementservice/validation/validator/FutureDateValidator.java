package com.ecommerce.hospitalmanagementservice.validation.validator;

import com.ecommerce.hospitalmanagementservice.validation.annotation.FutureDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class FutureDateValidator implements ConstraintValidator<FutureDate, LocalDate> {

    private int years;

    @Override
    public void initialize(FutureDate constraintAnnotation) {
        this.years = constraintAnnotation.year();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate == null) return false;

        return localDate.isAfter(LocalDate.now()) &&
                localDate.isBefore(LocalDate.now().plusYears(years));
    }
}
