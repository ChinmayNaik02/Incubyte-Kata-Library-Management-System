package com.chinmay.library;

import com.chinmay.exceptions.BookAlreadyExists;
import com.chinmay.exceptions.BookNotAvailableException;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Boolean> bookAvailability = new HashMap<>();


    public void addBook(String isbn, String title, String author, int publicationYear) {
        Book book = new Book(isbn, title, author, publicationYear);
        validateBook(book);
        books.put(book.getIsbn(),book);
        bookAvailability.put(isbn,true);
    }

    public boolean isBookInLibrary(String isbn) {
        return bookAvailability.getOrDefault(isbn,false);
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
        checkNotNullOrEmpty(isbn, "Book ISBN cannot be null or empty");

        if (!bookAvailability.getOrDefault(isbn,false)) {
            throw new BookNotAvailableException("Book is not in library");
        }
        bookAvailability.put(isbn,false);
    }

    public void returnBook(String isbn) {
        if (bookAvailability.getOrDefault(isbn,false)) {
            throw new BookAlreadyExists("Book Already exists in the library");
        }
        bookAvailability.put(isbn,true);  //Minimal Implementation
    }
}
