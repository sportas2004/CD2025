package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryServiceTest {
    @ParameterizedTest
    @CsvSource({"Sergio , 1, EL dia , 7899", "Miguel , 2, LA Noche, 7999"})
    void testAñadirLibro(String nombre, String id, String titulo, String isbn) {
        User objUsuario = new User(id, nombre);
        Book objLibro = new Book(isbn, titulo);
       LibraryService objService=new LibraryService();
       objService.addBook(objLibro);
       Exception exception = assertThrows(IllegalStateException.class, ()->{
           objService.addBook(objLibro);
           objService.addBook(objLibro);
       });
       assertEquals("Book already exists",exception.getMessage());
    }
}
