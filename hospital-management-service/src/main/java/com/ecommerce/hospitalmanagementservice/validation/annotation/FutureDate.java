package com.ecommerce.hospitalmanagementservice.validation.annotation;

import com.ecommerce.hospitalmanagementservice.validation.validator.FutureDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FutureDateValidator.class)
public @interface FutureDate {
    String message() default "Date must be in future and before limit";
    int year();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
