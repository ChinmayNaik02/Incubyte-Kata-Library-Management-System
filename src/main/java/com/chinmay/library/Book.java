package com.chinmay.library;

import static com.chinmay.utils.StringValidator.stringValidator;

/**
 * Represents a Book in the library.
 * A Book is immutable and requires valid ISBN, title, and author upon creation.
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;

    // Error messages for string validations
    private static final String ERROR_AUTHOR = "Book Author cannot be null or empty";
    private static final String ERROR_TITLE = "Book Title cannot be null or empty";
    private static final String ERROR_ISBN = "Book ISBN cannot be null or empty";

    /**
     * Constructor for creating a Book object.
     *
     * @param isbn             the unique ISBN identifier for the book, must not be null or empty
     * @param title            the title of the book, must not be null or empty
     * @param author           the author of the book, must not be null or empty
     * @param publicationYear  the year the book was published
     * @throws IllegalArgumentException if any of the mandatory fields (isbn, title, author) are null or empty
     */

    public Book(String isbn, String title, String author, int publicationYear) {
        stringValidator(isbn, ERROR_ISBN);
        stringValidator(title, ERROR_TITLE);
        stringValidator(author, ERROR_AUTHOR);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    //Getters for all fields of Book class
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
