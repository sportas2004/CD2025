package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Un usuario de la biblioteca que puede tomar prestados y devolver libros.
 */
public class User {

    private String id;
    private String name;
    private List<Loan> loans;

    /**
     * Crea un nuevo usuario.
     *
     * @param id el identificador del usuario
     * @param name el nombre del usuario
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.loans = new ArrayList<>();
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Devuelve el identificador del usuario.
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve los préstamos activos del usuario.
     *
     * @return lista de préstamos
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Añade un préstamo al usuario.
     *
     * @param loan el préstamo a añadir
     * @throws IllegalStateException si el usuario tiene ya 3 préstamos
     */
    public void addLoan(Loan loan) {
        if (loans.size() >= 3) {
            throw new IllegalStateException("Límite de préstamos alcanzado");
        }
        loans.add(loan);
    }

    /**
     * Elimina un préstamo cuando se devuelve el libro.
     *
     * @param loan el préstamo a eliminar
     */
    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }
}