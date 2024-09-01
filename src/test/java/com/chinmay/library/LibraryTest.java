package com.chinmay.library;

import static org.junit.jupiter.api.Assertions.*;

import com.chinmay.exceptions.BookAlreadyExists;
import com.chinmay.exceptions.BookNotAvailableException;
import com.chinmay.exceptions.BookRecordNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class LibraryTest {
    Library library;

    private static Stream<Arguments> provideInvalidBookData() {
        return Stream.of(
                Arguments.of(null, "1984", "George Orwell", 1949),
                Arguments.of("9788192910901", null, "George Orwell", 1949),
                Arguments.of("9788192910901", "1984", null, 1949),
                Arguments.of("", "1984", "George Orwell", 1949),
                Arguments.of("9788192910901", "", "George Orwell", 1949),
                Arguments.of("9788192910901", "1984", "", 1949),
                Arguments.of("  ", "1984", "George Orwell", 1949) //Any field with spaces throws exception
        );
    }

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    //Tests for addBooks() method
    @Test
    void testBookAddedSuccessfully() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        assertTrue(library.isBookAvailable("9788192910901"));
    }

    @Test
    void testReturnsFalseIfBookIsNotAdded() {
        assertFalse(library.isBookAvailable("1234567890"));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidBookData")
    void testAddBookWithInvalidInputsThrowsException(String isbn, String title, String author, int year) {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(isbn, title, author, year));
    }

    //Tests for borrowBooks() method
    @Test
    void testAllowToBorrowBookIfAvailable() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.borrowBook("9788192910901");
        assertFalse(library.isBookAvailable("9788192910901"));
    }

    @Test
    void testThrowsExceptionIfUnavailableBookIsBorrowed() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.borrowBook("9788192910901");
        assertThrows(BookNotAvailableException.class, ()->library.borrowBook("9788192910901"));
    }

    @Test
    void testBorrowingBookThatDoesNotExistThrowsException() {
        assertThrows(BookRecordNotFound.class, ()->library.borrowBook("1234567890"));
    }

    @Test
    void testBookBorrowedWithNullIsbnThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->library.borrowBook(null));
    }

    @Test
    void testBookBorrowedWithEmptyIsbnThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->library.borrowBook(""));
    }

    //Tests for returnBooks() method
    @Test
    void testReturnedBookShouldBeAvailable() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.borrowBook("9788192910901");
        library.returnBook("9788192910901");
        assertTrue(library.isBookAvailable("9788192910901"));
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

    @Test
    void testReturningAlreadyReturnedBookThrowsException() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.borrowBook("9788192910901");
        library.returnBook("9788192910901");
        assertThrows(BookAlreadyExists.class, ()->library.returnBook("9788192910901"));
    }

    @Test
    void testReturningBookWithNullIsbnThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->library.returnBook(null));
    }

    @Test
    void testReturningBookWithEmptyIsbnThrowsException() {
        assertThrows(IllegalArgumentException.class, ()->library.returnBook(""));
    }

    @Test
    void testCanAddBorrowAndReturnMultipleBooks() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.addBook("9780385121675","The Shining", "Stephen King",1977);

        library.borrowBook("9788192910901");
        library.borrowBook("9780385121675");

        library.returnBook("9788192910901");
        library.returnBook("9780385121675");

        assertTrue(library.isBookAvailable("9788192910901"));
        assertTrue(library.isBookAvailable("9780385121675"));
    }

    //Tests for viewAvailableBooks() method
    @Test
    void testAllAvailableBooksAreDisplayed() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.addBook("9780007124015", "The Lord of the Rings", "John Ronald Reuel Tolkien", 1954);

        library.borrowBook("9788192910901");

        List<Book> availableBooks = library.viewAvailableBooks();

        assertEquals(1, availableBooks.size());
    }

    @Test
    void testNoBooksAreDisplayedWhenAllBooksAreBorrowed() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.addBook("9780385121675","The Shining", "Stephen King",1977);

        library.borrowBook("9788192910901");
        library.borrowBook("9780385121675");

        List<Book> availableBooks = library.viewAvailableBooks();

        assertTrue(availableBooks.isEmpty());
    }

    @Test
    void testAllAvailableBooksAreDisplayedWhenMultipleBooksAreAvailable() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.addBook("9780385121675","The Shining", "Stephen King",1977);

        List<Book> availableBooks = library.viewAvailableBooks();

        assertTrue(availableBooks.stream().anyMatch(book -> book.getIsbn().equals("9788192910901")));
        assertTrue(availableBooks.stream().anyMatch(book -> book.getIsbn().equals("9780385121675")));
    }

    @Test
    void testAllAvailableBooksAreDisplayedWhenSomeBooksAreBorrowed() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.addBook("9780385121675","The Shining", "Stephen King",1977);

        library.borrowBook("9788192910901");

        List<Book> availableBooks = library.viewAvailableBooks();

        assertTrue(availableBooks.stream().anyMatch(book -> book.getIsbn().equals("9780385121675")));
    }

    @Test
    void testAllAvailableBooksAreDisplayedWhenSomeBooksAreReturned() {
        library.addBook("9788192910901", "1984", "George Orwell", 1949);
        library.addBook("9780385121675","The Shining", "Stephen King",1977);

        library.borrowBook("9788192910901");

        library.returnBook("9788192910901");

        List<Book> availableBooks = library.viewAvailableBooks();

        assertTrue(availableBooks.stream().anyMatch(book -> book.getIsbn().equals("9788192910901")));
        assertTrue(availableBooks.stream().anyMatch(book -> book.getIsbn().equals("9780385121675")));
    }
}