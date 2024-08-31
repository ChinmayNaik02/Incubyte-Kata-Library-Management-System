package com.chinmay.library;

import com.chinmay.exceptions.BookAlreadyExists;
import com.chinmay.exceptions.BookNotAvailableException;
import com.chinmay.exceptions.BookRecordNotFound;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private static final String ERROR_MESSAGE_AUTHOR = "Book Author cannot be null or empty";
    private static final String ERROR_MESSAGE_TITLE = "Book Title cannot be null or empty";
    private static final String ERROR_MESSAGE_ISBN = "Book ISBN cannot be null or empty";
    
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Boolean> bookAvailability = new HashMap<>();


    public void addBook(String isbn, String title, String author, int publicationYear) {
        Book book = new Book(isbn, title, author, publicationYear);
        validateBook(book);
        books.put(book.getIsbn(),book);
        bookAvailability.put(isbn,true);
    }

    public void borrowBook(String isbn) {
        checkNotNullOrEmpty(isbn, ERROR_MESSAGE_ISBN);

        if (Boolean.FALSE.equals(bookAvailability.getOrDefault(isbn,false))) {
            throw new BookNotAvailableException(isbn);
        }
        bookAvailability.put(isbn,false);
    }

    public void returnBook(String isbn) {
        checkNotNullOrEmpty(isbn, ERROR_MESSAGE_ISBN);

        if (!books.containsKey(isbn)) {
            throw new BookRecordNotFound(isbn);
        }
        if (Boolean.TRUE.equals(bookAvailability.get(isbn))) {
            throw new BookAlreadyExists(isbn);
        }
        bookAvailability.put(isbn,true);
    }

    public boolean isBookAvailable(String isbn) {
        return bookAvailability.getOrDefault(isbn,false);
    }

    private void validateBook(Book book) {
        checkNotNullOrEmpty(book.getIsbn(), ERROR_MESSAGE_ISBN);
        checkNotNullOrEmpty(book.getTitle(), ERROR_MESSAGE_TITLE);
        checkNotNullOrEmpty(book.getAuthor(), ERROR_MESSAGE_AUTHOR);
    }

    private void checkNotNullOrEmpty(String value, String errorMessage) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
