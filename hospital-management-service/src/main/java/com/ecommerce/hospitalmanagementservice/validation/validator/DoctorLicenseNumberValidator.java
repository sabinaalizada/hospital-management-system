package com.ecommerce.hospitalmanagementservice.validation.validator;

import com.ecommerce.hospitalmanagementservice.validation.annotation.DoctorLicenseNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DoctorLicenseNumberValidator implements ConstraintValidator<DoctorLicenseNumber, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null || s.isEmpty()) return true;

        s = s.trim();

        if (s.length() != 9) return false;

        if (!s.startsWith("AH ")) return false;

        for (int i = 3; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }

        return true;
    }

/* example AH 123456
the first 2 letters must be A and H
following by space and ends with 6 digits
 */

}
