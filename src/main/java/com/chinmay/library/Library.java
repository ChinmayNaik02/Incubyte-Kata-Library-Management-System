package com.chinmay.library;

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
        if (book.getIsbn() == null) {
            throw new IllegalArgumentException("Book Isbn cannot be empty");
        }
        if (book.getTitle() == null){
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if (book.getAuthor() == null){
            throw new IllegalArgumentException("Book author cannot be empty");
        }
    }
}
