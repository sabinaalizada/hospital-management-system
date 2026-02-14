package com.ecommerce.hospitalmanagementservice.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
    MALE,
    FEMALE,
    OTHER;

    @JsonCreator
    public static Gender parse(String value) {
        return Gender.valueOf(value.trim().toUpperCase());
    }
}
