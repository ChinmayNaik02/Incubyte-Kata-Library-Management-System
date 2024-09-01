package com.chinmay.utils;

/**
 * Utility class for validating strings.
 * Ensures that strings are not null and not empty after trimming.
 */
public class StringValidator {

    // Private constructor to prevent instantiation
    private StringValidator(){}

    /**
     * Validates that the provided string is not null and not empty after trimming.
     *
     * @param value        the string to validate
     * @param errorMessage the error message to include in the exception if validation fails
     * @throws IllegalArgumentException if the string is null or empty
     */
    public static void stringValidator(String value, String errorMessage) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
