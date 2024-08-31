package com.chinmay.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookCreationAndGetters() {
        Book book = new Book("9788192910901", "1984", "George Orwell", 1949);
        assertNotNull(book);
        assertEquals("9788192910901", book.getIsbn());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals("1984", book.getTitle());
        assertEquals(1949, book.getPublicationYear());
    }
}
