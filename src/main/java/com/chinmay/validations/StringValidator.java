package com.chinmay.validations;

public class StringValidator {

    private StringValidator(){}

    public static void checkNotNullOrEmpty(String value, String errorMessage) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
