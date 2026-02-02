package com.ecommerce.hospitalmanagementservice.validation.validator;

import com.ecommerce.hospitalmanagementservice.validation.annotation.OnlyLetters;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class OnlyLettersValidator implements ConstraintValidator<OnlyLetters, String> {

    private Pattern pattern;

    @Override
    public void initialize(OnlyLetters constraintAnnotation) {
        if (constraintAnnotation.allowSpace()){
            pattern = Pattern.compile("^[a-zA-Z ]+$");
        }else {
            pattern = Pattern.compile("^[a-zA-Z]+$");
        }
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s == null || s.isEmpty()) return true;
        return pattern.matcher(s).matches();
    }
}
