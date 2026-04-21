package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


    class BookTest {

    @ParameterizedTest
    @CsvSource({"Sergio , 7899", "Miguel , 7899"})
    void testCrearConstructorLibro(String titular, String isbn) {
      Book objLibro=new Book(isbn,titular);
        assertEquals(titular,objLibro.getTitle());
        assertEquals(isbn,objLibro.getIsbn());
    }


    @ParameterizedTest
    @CsvSource({"Sergio , 7899", "Miguel , 7899"})
    void testSolicitarLibro(String titular, String isbn) {

          Book objLibro=new Book(isbn,titular);
          assertEquals(objLibro.isAvailable(),true);
          objLibro.borrow();
          assertEquals(objLibro.isAvailable(),false);

          Exception exception = assertThrows(IllegalStateException.class, () -> {
              objLibro.borrow();
          });

            assertEquals("Book not available", exception.getMessage());
    }


    @ParameterizedTest
    @CsvSource({"Sergio , 7899", "Miguel , 7899"})
    void testDevolverLibro(String titular, String isbn) {
        Book objLibro = new Book(isbn, titular);
        assertEquals(objLibro.isAvailable(), true);
        objLibro.borrow();
        assertEquals(objLibro.isAvailable(), false);
        objLibro.giveBack();
        assertEquals(objLibro.isAvailable(), true);

    }

}
