package com.chinmay.exceptions;

public class BookRecordNotFound extends RuntimeException {
    public BookRecordNotFound(String isbn) {
        super("The book with isbn "+isbn+" does not exist in the library");
    }
}
