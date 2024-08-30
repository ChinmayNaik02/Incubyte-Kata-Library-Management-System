package com.chinmay.library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LibraryTest {

    @Test
    void returnsTrueIfBookIsAvailable() {
        Library library = new Library();
        Book book = new Book("9788192910901", "1984", "George Orwell", 1949);
        library.addBook(book);
        assertTrue(library.isBookInLibrary("9788192910901"));
    }

    @Test
    void returnsFalseIfBookIsAvailable() {
        Library library = new Library();
        assertFalse(library.isBookInLibrary("1234567890"));
    }


}