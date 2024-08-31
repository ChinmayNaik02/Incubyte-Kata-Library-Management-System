package com.chinmay.library;

import static com.chinmay.validations.StringValidator.checkNotNullOrEmpty;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;

    private static final String ERROR_MESSAGE_AUTHOR = "Book Author cannot be null or empty";
    private static final String ERROR_MESSAGE_TITLE = "Book Title cannot be null or empty";
    private static final String ERROR_MESSAGE_ISBN = "Book ISBN cannot be null or empty";

    public Book(String isbn, String title, String author, int publicationYear) {
        checkNotNullOrEmpty(isbn, ERROR_MESSAGE_ISBN);
        checkNotNullOrEmpty(title, ERROR_MESSAGE_TITLE);
        checkNotNullOrEmpty(author, ERROR_MESSAGE_AUTHOR);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

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
