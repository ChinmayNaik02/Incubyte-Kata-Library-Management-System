package com.chinmay.library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LibraryTest {

    void testAddBook() {
        Library library = new Library();
        Book book = new Book("9788192910901", "1984", "George Orwell", 1949);
        library.addBook(book);
    }
}