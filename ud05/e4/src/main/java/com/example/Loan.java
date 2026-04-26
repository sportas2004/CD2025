package com.example;
import java.time.LocalDate;

/**
 * Un registro de préstamo de un libro.
 */
public class Loan {

    private Book book;
    private User user;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Crea un nuevo préstamo entre un libro y un usuario.
     *
     * @param book el libro prestado
     * @param user el usuario que presta el libro
     */
    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.startDate = LocalDate.now();
    }

    /**
     * Devuelve el libro prestado.
     *
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Devuelve el usuario que tomó el libro en préstamo.
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Devuelve la fecha de inicio del préstamo.
     *
     * @return start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Cierra el préstamo y registra la fecha de fin.
     */
    public void closeLoan() {
        this.endDate = LocalDate.now();
    }

    /**
     * Indica si el préstamo sigue activo.
     *
     * @return true si el préstamo no se ha cerrado
     */
    public boolean isActive() {
        return endDate == null;
    }
}