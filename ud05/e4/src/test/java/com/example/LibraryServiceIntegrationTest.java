package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceIntegrationTest {

    @Test
    void shouldBorrowBookCorrectly() {
        LibraryService service = new LibraryService();

        Book book = new Book("123", "Clean Code");
        User user = new User("u1", "Ana");

        service.addBook(book);
        service.addUser(user);

        Loan loan = service.borrowBook("123", "u1");

        assertNotNull(loan);
        assertEquals(book, loan.getBook());
        assertEquals(user, loan.getUser());
        assertFalse(book.isAvailable());
        assertEquals(1, user.getLoans().size());
        assertTrue(user.getLoans().contains(loan));
        assertTrue(loan.isActive());
    }

    @Test
    void shouldReturnBookCorrectly() {
        LibraryService service = new LibraryService();

        Book book = new Book("123", "Clean Code");
        User user = new User("u1", "Ana");

        service.addBook(book);
        service.addUser(user);

        Loan loan = service.borrowBook("123", "u1");
        service.returnBook(loan);

        assertFalse(loan.isActive());
        assertTrue(book.isAvailable());
        assertTrue(user.getLoans().isEmpty());
    }

    @Test
    void shouldNotReturnBookTwice() {
        LibraryService service = new LibraryService();

        Book book = new Book("123", "Clean Code");
        User user = new User("u1", "Ana");

        service.addBook(book);
        service.addUser(user);

        Loan loan = service.borrowBook("123", "u1");
        service.returnBook(loan);

        Exception exception = assertThrows(IllegalStateException.class, () -> service.returnBook(loan));
        assertEquals("Préstamo ya cerrado", exception.getMessage());
    }

    @Test
    void shouldRejectInvalidBorrowData() {
        LibraryService service = new LibraryService();
        service.addBook(new Book("123", "Clean Code"));
        service.addUser(new User("u1", "Ana"));

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> service.borrowBook("999", "u1"));
        assertEquals("Datos inválidos", exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> service.borrowBook("123", "u2"));
        assertEquals("Datos inválidos", exception2.getMessage());
    }

    @Test
    void shouldRejectBorrowWhenBookNotAvailable() {
        LibraryService service = new LibraryService();
        Book book = new Book("123", "Clean Code");
        User firstUser = new User("u1", "Ana");
        User secondUser = new User("u2", "Beto");

        service.addBook(book);
        service.addUser(firstUser);
        service.addUser(secondUser);

        service.borrowBook("123", "u1");

        Exception exception = assertThrows(IllegalStateException.class, () -> service.borrowBook("123", "u2"));
        assertEquals("Libro no disponible", exception.getMessage());
    }

    @Test
    void shouldRejectBorrowWhenUserHasMaxLoans() {
        LibraryService service = new LibraryService();
        Book book1 = new Book("123", "Clean Code");
        Book book2 = new Book("456", "Refactoring");
        Book book3 = new Book("789", "Domain-Driven Design");
        Book book4 = new Book("999", "Test-Driven Development");
        User user = new User("u1", "Ana");

        service.addBook(book1);
        service.addBook(book2);
        service.addBook(book3);
        service.addBook(book4);
        service.addUser(user);

        service.borrowBook("123", "u1");
        service.borrowBook("456", "u1");
        service.borrowBook("789", "u1");

        Exception exception = assertThrows(IllegalStateException.class, () -> service.borrowBook("999", "u1"));
        assertEquals("Límite de préstamos alcanzado", exception.getMessage());
    }
}
