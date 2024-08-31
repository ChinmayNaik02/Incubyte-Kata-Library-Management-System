package com.chinmay.library;

import com.chinmay.exceptions.BookNotAvailableException;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(String isbn, String title, String author, int publicationYear) {
        Book book = new Book(isbn, title, author, publicationYear);
        validateBook(book);
        books.put(book.getIsbn(),book);
    }

    public boolean isBookInLibrary(String isbn) {
        return books.containsKey(isbn);
    }

    private void validateBook(Book book) {
        checkNotNullOrEmpty(book.getIsbn(), "Book ISBN cannot be null or empty");
        checkNotNullOrEmpty(book.getTitle(), "Book Title cannot be null or empty");
        checkNotNullOrEmpty(book.getAuthor(), "Book Author cannot be null or empty");
    }

    private void checkNotNullOrEmpty(String value, String errorMessage) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void borrowBook(String isbn) {
        if (!isBookInLibrary(isbn)) {
            throw new BookNotAvailableException("Book is not in library");
        }
        books.remove(isbn);
    }
}
