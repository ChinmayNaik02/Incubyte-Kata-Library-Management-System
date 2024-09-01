package com.chinmay.library;

import com.chinmay.exceptions.BookAlreadyExists;
import com.chinmay.exceptions.BookNotAvailableException;
import com.chinmay.exceptions.BookRecordNotFound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.chinmay.utils.StringValidator.stringValidator;

/**
 * The Library class manages the collection of books and their availability.
 * It provides functionalities to add, borrow, return, and view books.
 */
public class Library {
    private static final String ERROR_ISBN = "Book ISBN cannot be null or empty";

    // Stores books with their ISBN as the key
    private final Map<String, Book> books = new HashMap<>();

    // Tracks the availability of each book (true if available, false if borrowed)
    private final Map<String, Boolean> bookAvailability = new HashMap<>();

    /**
     * Adds a new book to the library collection and marks it as available.
     *
     * @param isbn             the ISBN of the book, must not be null or empty
     * @param title            the title of the book, must not be null or empty
     * @param author           the author of the book, must not be null or empty
     * @param publicationYear  the year the book was published
     */
    public void addBook(String isbn, String title, String author, int publicationYear) {
        Book book = new Book(isbn, title, author, publicationYear);
        books.put(book.getIsbn(),book);
        bookAvailability.put(isbn,true);
    }

    /**
     * Borrows a book from the library, marking it as unavailable.
     *
     * @param isbn the ISBN of the book to borrow, must not be null or empty
     * @throws BookRecordNotFound if the book with the given ISBN is not found
     * @throws BookNotAvailableException if the book is already borrowed
     */
    public void borrowBook(String isbn) {
        stringValidator(isbn, ERROR_ISBN);

        if (!books.containsKey(isbn)) {
            throw new BookRecordNotFound(isbn);
        }

        if (Boolean.FALSE.equals(bookAvailability.getOrDefault(isbn,false))) {
            throw new BookNotAvailableException(isbn);
        }
        bookAvailability.put(isbn,false);
    }

    /**
     * Returns a borrowed book to the library, marking it as available.
     *
     * @param isbn the ISBN of the book to return, must not be null or empty
     * @throws BookRecordNotFound if the book with the given ISBN is not found
     * @throws BookAlreadyExists if the book is already available
     */
    public void returnBook(String isbn) {
        stringValidator(isbn, ERROR_ISBN);

        if (!books.containsKey(isbn)) {
            throw new BookRecordNotFound(isbn);
        }
        if (Boolean.TRUE.equals(bookAvailability.get(isbn))) {
            throw new BookAlreadyExists(isbn);
        }
        bookAvailability.put(isbn,true);
    }

    /**
     * Returns a list of all available books in the library.
     *
     * @return a list of available books
     */
    public List<Book> viewAvailableBooks() {
        return books.values()
                .stream()
                .filter(book -> bookAvailability.getOrDefault(book.getIsbn(),false))
                .collect(Collectors.toList());
    }

    /**
     * Checks if a book is available in the library.
     *
     * @param isbn the ISBN of the book to check
     * @return true if the book is available, false otherwise
     */
    public boolean isBookAvailable(String isbn) {
        return bookAvailability.getOrDefault(isbn,false);
    }
}
