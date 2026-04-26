package com.example;

/**
 * Un libro que puede ser prestado en la biblioteca.
 */
public class Book {

    private String isbn;
    private String title;
    private boolean available;

    /**
     * Crea una nueva instancia de libro.
     *
     * @param isbn el ISBN del libro
     * @param title el título del libro
     */
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.available = true;
    }

    /**
     * Devuelve el ISBN del libro.
     *
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Devuelve el título del libro.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Indica si el libro está disponible para préstamo.
     *
     * @return true si está disponible
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Marca el libro como prestado.
     *
     * @throws IllegalStateException si el libro no está disponible
     */
    public void borrow() {
        if (!available) {
            throw new IllegalStateException("Libro no disponible");
        }
        available = false;
    }

    /**
     * Marca el libro como devuelto y disponible nuevamente.
     */
    public void giveBack() {
        available = true;
    }
}