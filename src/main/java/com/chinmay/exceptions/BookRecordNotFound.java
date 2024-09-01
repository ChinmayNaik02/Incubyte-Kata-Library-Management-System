package com.chinmay.exceptions;

/**
 * Exception thrown when a book with the specified ISBN is not found in the library.
 */
public class BookRecordNotFound extends RuntimeException {
    public BookRecordNotFound(String isbn) {
        super("The book with isbn "+isbn+" does not exist in the library");
    }
}
