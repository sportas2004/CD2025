package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryServiceTest {
    @ParameterizedTest
    @CsvSource({"Sergio , 1, EL dia , 7899", "Miguel , 2, LA Noche, 7999"})
    void testAñadirLibro(String nombre, String id, String titulo, String isbn) {
        Book objLibro = new Book(isbn, titulo);
        LibraryService objService = new LibraryService();

        objService.addBook(objLibro);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> objService.addBook(objLibro));
        assertEquals("El libro ya existe", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"Ana , 1", "Bego , 2"})
    void testAñadirUsuarioDuplicado(String nombre, String id) {
        User user = new User(id, nombre);
        LibraryService service = new LibraryService();

        service.addUser(user);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.addUser(user));
        assertEquals("El usuario ya existe", exception.getMessage());
    }
}
