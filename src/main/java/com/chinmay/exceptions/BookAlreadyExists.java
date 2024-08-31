package com.chinmay.exceptions;

public class BookAlreadyExists extends RuntimeException {
    public BookAlreadyExists(String isbn) {
        super("Book with isbn "+isbn+" already exists in the library");
    }
}
