package com.ecommerce.hospitalmanagementservice.validation.validator;

import com.ecommerce.hospitalmanagementservice.validation.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private static final String PHONE_PATTERN = "^0(50|51|55|70|77|10|99)\\d{7}$";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return true;
        return s.matches(PHONE_PATTERN);
    }

    /*
    phone number must begin with any of these
    prefixes 050/051/070/077/010/099
    following by 7 digits
     */
}
