package com.example;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestAlumno {

    @Test
    void constructorSinNada() {
        Alumno alumno = new Alumno();
        assertNotNull(alumno);
        assertEquals(null, alumno.getNombre());
        assertEquals(0, alumno.getEdad());
        assertEquals(0.0, alumno.getNotaMedia());
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0 ","Jose , 16, 4.0 "})
    void constructorConParametros(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        assertNotNull(alumno);
        assertEquals(nombre, alumno.getNombre());
        assertEquals(edad, alumno.getEdad());
        assertEquals(notaMedia, alumno.getNotaMedia());
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0 ","Jose , 16, 4.0 "})
    void introducirParametros(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno();
        assertNotNull(alumno);
        alumno.setNombre(nombre);
        alumno.setEdad(edad);
        alumno.setNotaMedia(notaMedia);
        assertEquals(nombre, alumno.getNombre());
        assertEquals(edad, alumno.getEdad());
        assertEquals(notaMedia, alumno.getNotaMedia());
    }



}
