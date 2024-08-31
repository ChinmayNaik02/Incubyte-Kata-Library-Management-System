package com.chinmay.library;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (book.getIsbn() == null) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        books.put(book.getIsbn(),book);
    }

    public boolean isBookInLibrary(String isbn) {
        return books.containsKey(isbn);
    }
}
