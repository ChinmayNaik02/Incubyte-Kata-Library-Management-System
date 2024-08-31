package com.chinmay.exceptions;

public class BookRecordNotFound extends RuntimeException {
    public BookRecordNotFound(String message) {
        super(message);
    }
}
