package com.chinmay.exceptions;

public class BookAlreadyExists extends RuntimeException {
    public BookAlreadyExists(String message) {
        super(message);
    }
}
