package com.ecommerce.hospitalmanagementservice.validation.annotation;

import com.ecommerce.hospitalmanagementservice.validation.validator.OnlyLettersValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OnlyLettersValidator.class)
public @interface OnlyLetters {
    String message() default "Only letters allowed";
    boolean allowSpace() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
