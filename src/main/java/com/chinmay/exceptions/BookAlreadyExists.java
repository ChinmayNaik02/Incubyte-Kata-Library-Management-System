package com.chinmay.exceptions;

public class BookAlreadyExists extends Exception {
    public BookAlreadyExists(String message) {
        super(message);
    }
}
