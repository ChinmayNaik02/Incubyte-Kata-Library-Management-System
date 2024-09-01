package com.chinmay.exceptions;

/**
 * Exception thrown when a book with the specified ISBN already exists in the library.
 */
public class BookAlreadyExists extends RuntimeException {
    public BookAlreadyExists(String isbn) {
        super("Book with isbn "+isbn+" already exists in the library");
    }
}
