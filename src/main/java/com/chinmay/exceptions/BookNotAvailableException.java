package com.chinmay.exceptions;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(String isbn) {
        super("Book with isbn "+isbn+" is currently unavailable.");
    }
}
