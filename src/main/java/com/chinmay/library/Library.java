package com.chinmay.library;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Boolean> availability = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(),book);
        availability.put(book.getIsbn(),true);
    }

    public boolean isBookAvailable(String isbn) {
        return availability.getOrDefault(isbn,false);
    }
}
