package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoanTest {

    @ParameterizedTest
    @CsvSource({"Sergio , 1, EL dia , 7899", "Miguel , 2, LA Noche, 7999"})
    void testConstructorLoad(String nombre, String id, String titulo, String isbn) {
        User objUsuario = new User(id, nombre);
        Book objLibro = new Book(isbn, titulo);
        Loan objLoan = new Loan(objLibro, objUsuario);
        assertEquals(objLibro, objLoan.getBook());
        assertEquals(objUsuario, objLoan.getUser());
        assertEquals(LocalDate.now(),objLoan.getStartDate());
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 1, EL dia , 7899", "Miguel , 2, LA Noche, 7999"})
    void testFechaComprobacion(String nombre, String id, String titulo, String isbn) {
        User objUsuario = new User(id, nombre);
        Book objLibro = new Book(isbn, titulo);
        Loan objLoan = new Loan(objLibro, objUsuario);
        assertEquals(true,objLoan.isActive());
        objLoan.closeLoan();
        assertEquals(false,objLoan.isActive());
    }

}
