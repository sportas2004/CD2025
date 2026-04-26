package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Servicio para gestionar libros, usuarios y préstamos de la biblioteca.
 */
public class LibraryService {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    /**
     * Añade un nuevo libro al catálogo de la biblioteca.
     *
     * @param book el libro que se añade
     * @throws IllegalArgumentException si el libro ya existe
     */
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("El libro ya existe");
        }
        books.put(book.getIsbn(), book);
    }

    /**
     * Registra un usuario nuevo en la biblioteca.
     *
     * @param user el usuario que se registra
     * @throws IllegalArgumentException si el usuario ya existe
     */
    public void addUser(User user) {
        if (users.containsKey(user.getId())) {
            throw new IllegalArgumentException("El usuario ya existe");
        }
        users.put(user.getId(), user);
    }

    /**
     * Realiza un préstamo de un libro a un usuario.
     *
     * @param isbn el ISBN del libro
     * @param userId el identificador del usuario
     * @return el préstamo creado
     * @throws IllegalArgumentException si el libro o el usuario no son válidos
     */
    public Loan borrowBook(String isbn, String userId) {
        Book book = books.get(isbn);
        User user = users.get(userId);

        if (book == null || user == null) {
            throw new IllegalArgumentException("Datos inválidos");
        }

        if (!book.isAvailable()) {
            throw new IllegalStateException("Libro no disponible");
        }

        if (user.getLoans().size() >= 3) {
            throw new IllegalStateException("Límite de préstamos alcanzado");
        }

        book.borrow();

        Loan loan = new Loan(book, user);
        user.addLoan(loan);

        return loan;
    }

    /**
     * Devuelve un libro prestado y cierra el préstamo.
     *
     * @param loan el préstamo que debe cerrarse
     * @throws IllegalStateException si el préstamo ya está cerrado
     */
    public void returnBook(Loan loan) {
        if (!loan.isActive()) {
            throw new IllegalStateException("Préstamo ya cerrado");
        }

        loan.closeLoan();
        loan.getBook().giveBack();
        loan.getUser().removeLoan(loan);
    }
}