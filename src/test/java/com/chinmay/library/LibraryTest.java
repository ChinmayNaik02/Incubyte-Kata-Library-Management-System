package com.chinmay.library;

import static org.junit.jupiter.api.Assertions.*;

import com.chinmay.exceptions.BookAlreadyExists;
import com.chinmay.exceptions.BookNotAvailableException;
import com.chinmay.exceptions.BookRecordNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {
    Library library;
    
    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void returnsTrueIfBookIsAvailable() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        assertTrue(library.isBookInLibrary("9788192910901"));
    }

    @Test
    void returnsFalseIfBookIsAvailable() {
        assertFalse(library.isBookInLibrary("1234567890"));
    }

    @Test
    void testAddBookWithNullIsbnThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null, "1984", "George Orwell", 1949));
    }

    @Test
    void testAddBookWithNullTitleThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->library.addBook("9788192910901", null, "George Orwell", 1949));
    }

    @Test
    void testAddBookWithNullAuthorThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->library.addBook("9788192910901", "1984", null, 1949));
    }

    @Test
    void testAddBookWithEmptyIsbnThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook("", "1984", "George Orwell", 1949));
    }

    @Test
    void testAddBookWithEmptyTitleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook("9788192910901", "", "George Orwell", 1949));
    }

    @Test
    void testAddBookWithEmptyAuthorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook("9788192910901", "1984", "", 1949));
    }

    @Test
    void testAllowToBorrowBookIfAvailable() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.borrowBook("9788192910901");
        assertFalse(library.isBookInLibrary("9788192910901"));
    }

    @Test
    void testThrowsExceptionIfUnavailableBookIsBorrowed() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.borrowBook("9788192910901");
        assertThrows(BookNotAvailableException.class, ()->library.borrowBook("9788192910901"));
    }

    @Test
    void testBookBorrowedWithNullIsbnThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->library.borrowBook(null));
    }

    @Test
    void testBookBorrowedWithEmptyIsbnThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->library.borrowBook(""));
    }

    @Test
    void testReturnedBookShouldBeAvailable() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.borrowBook("9788192910901");
        library.returnBook("9788192910901");
        assertTrue(library.isBookInLibrary("9788192910901"));
    }

    @Test
    void testReturningAlreadyPresentBookThrowsException() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        assertThrows(BookAlreadyExists.class, ()->library.returnBook("9788192910901"));
    }

    @Test
    void testReturningBookThatDoesNotExistThrowsException() {
        assertThrows(BookRecordNotFound.class, () -> library.returnBook("9788192910901"));
    }
}