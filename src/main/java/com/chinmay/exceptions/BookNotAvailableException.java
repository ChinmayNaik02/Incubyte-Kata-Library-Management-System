package com.chinmay.exceptions;

/**
 * Exception thrown when a book with the specified ISBN is currently unavailable.
 */
public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(String isbn) {
        super("Book with isbn "+isbn+" is currently unavailable.");
    }
}
