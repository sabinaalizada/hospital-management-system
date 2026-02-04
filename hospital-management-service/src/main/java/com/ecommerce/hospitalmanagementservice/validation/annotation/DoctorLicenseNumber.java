package com.ecommerce.hospitalmanagementservice.validation.annotation;

import com.ecommerce.hospitalmanagementservice.validation.validator.DoctorLicenseNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DoctorLicenseNumberValidator.class)
public @interface DoctorLicenseNumber {
    String message() default "License number is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

/* example AH 123456
the first 2 letters must be A and H
following by space and 6 digits
 */
