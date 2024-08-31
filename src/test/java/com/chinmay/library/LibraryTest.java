package com.chinmay.library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LibraryTest {

    @Test
    void returnsTrueIfBookIsAvailable() {
        Library library = new Library();
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        assertTrue(library.isBookInLibrary("9788192910901"));
    }

    @Test
    void returnsFalseIfBookIsAvailable() {
        Library library = new Library();
        assertFalse(library.isBookInLibrary("1234567890"));
    }

    @Test
    void testAddBookWithNullIsbnThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null, "1984", "George Orwell", 1949));
    }

    @Test
    void testAddBookWithNullTitleThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, ()->library.addBook("9788192910901", null, "George Orwell", 1949));
    }

    @Test
    void testAddBookWithNullAuthorThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, ()->library.addBook("9788192910901", "1984", null, 1949));
    }

    @Test
    void testAddBookWithEmptyIsbnThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.addBook("", "1984", "George Orwell", 1949));
    }

    @Test
    void testAddBookWithEmptyTitleThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.addBook("9788192910901", "", "George Orwell", 1949));
    }

    @Test
    void testAddBookWithEmptyAuthorThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.addBook("9788192910901", "1984", "", 1949));
    }

    @Test
    void testAllowToBorrowBookIfAvailable() {
        Library library = new Library();
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.borrowBook("9788192910901");
        assertFalse(library.isBookInLibrary("9788192910901"));
    }
}