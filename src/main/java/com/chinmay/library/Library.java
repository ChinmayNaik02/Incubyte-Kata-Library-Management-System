package com.chinmay.library;

import com.chinmay.exceptions.BookAlreadyExists;
import com.chinmay.exceptions.BookNotAvailableException;
import com.chinmay.exceptions.BookRecordNotFound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.chinmay.validations.StringValidator.checkNotNullOrEmpty;

public class Library {
    private static final String ERROR_MESSAGE_ISBN = "Book ISBN cannot be null or empty";
    
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Boolean> bookAvailability = new HashMap<>();


    public void addBook(String isbn, String title, String author, int publicationYear) {
        Book book = new Book(isbn, title, author, publicationYear);
        books.put(book.getIsbn(),book);
        bookAvailability.put(isbn,true);
    }

    public void borrowBook(String isbn) {
        checkNotNullOrEmpty(isbn, ERROR_MESSAGE_ISBN);

        if (!books.containsKey(isbn)) {
            throw new BookRecordNotFound(isbn);
        }

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

    public List<Book> viewAvailableBooks() {
        return books.values()
                .stream()
                .filter(book -> bookAvailability.getOrDefault(book.getIsbn(),false))
                .collect(Collectors.toList());
    }

    public boolean isBookAvailable(String isbn) {
        return bookAvailability.getOrDefault(isbn,false);
    }
}
