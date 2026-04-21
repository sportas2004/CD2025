package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @ParameterizedTest
    @CsvSource({"Sergio , 1", "Miguel , 2"})
        void testCrearConstructorUser(String nombre, String id) {
        User objUsuario= new User(id,nombre);
        assertEquals(nombre,objUsuario.getName());
        assertEquals(id,objUsuario.getId());
        List<Loan> loan=new ArrayList<>();
        assertEquals(loan,objUsuario.getLoans());
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 1, EL dia , 7899", "Miguel , 2, LA Noche, 7999"})
    void testComprobacionLoanAñadir(String nombre, String id, String titulo, String isbn) {
        User objUsuario = new User(id, nombre);
        Book objLibro = new Book(isbn, titulo);
        Loan objLoan = new Loan(objLibro, objUsuario);
        objUsuario.addLoan(objLoan);
        List<Loan> loan = new ArrayList<>();
        loan.add(objLoan);
        assertEquals(loan, objUsuario.getLoans());
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            objUsuario.addLoan(objLoan);
            objUsuario.addLoan(objLoan);
            objUsuario.addLoan(objLoan);
        });
        assertEquals("Max loans reached", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 1, EL dia , 7899", "Miguel , 2, LA Noche, 7999"})
    void testEliminarLoad(String nombre, String id, String titulo, String isbn) {
        User objUsuario = new User(id, nombre);
        Book objLibro = new Book(isbn, titulo);
        Loan objLoan = new Loan(objLibro, objUsuario);
        objUsuario.addLoan(objLoan);
        List<Loan> loan = new ArrayList<>();
        loan.add(objLoan);
        assertEquals(loan, objUsuario.getLoans());
        loan.clear();
        objUsuario.removeLoan(objLoan);
        assertEquals(loan, objUsuario.getLoans());
    }


}
