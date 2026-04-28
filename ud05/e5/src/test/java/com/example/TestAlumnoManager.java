package com.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

 class TestAlumnoManager {

 @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0 ","Jose , 16, 4.0 "})
    void añadirAlumno(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        assertNotNull(alumno);
        assertEquals(nombre, alumno.getNombre());
        assertEquals(edad, alumno.getEdad());
        assertEquals(notaMedia, alumno.getNotaMedia());
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        assertEquals(alumno, alumnoManager.buscarAlumnoPorNombre(nombre));
    }

    @Test
    void añadirAlumnoV2() {
        Alumno alumno = new Alumno();
        assertNotNull(alumno);
        AlumnoManager alumnoManager = new AlumnoManager();
        assertEquals(null,alumnoManager.buscarAlumnoPorNombre(""));
    }

    @Test
    void añadirAlumnoV3() {
        Alumno alumno = null;
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        ArrayList alumnos=new ArrayList<>();
        assertEquals(alumnos,alumnoManager.getAlumnos());
    }

    @Test
    void clasificarAlumno() {
        Alumno alumno = null;
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        assertEquals("Alumno nulo",alumnoManager.clasificarAlumno(alumno));
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0 ","Jose , 16, 4.0 "})
    void calcularMedia(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        alumnoManager.calcularMedia();
        assertEquals(notaMedia, alumnoManager.calcularMedia());
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0"})
    void calcularMediaV2(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        Alumno alumno2 = new Alumno("Jose", 16, 4.0);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        alumnoManager.agregarAlumno(alumno2);
        alumnoManager.calcularMedia();
        assertEquals((notaMedia + alumno2.getNotaMedia())/2, alumnoManager.calcularMedia());
    }

    @Test
    void calcularMediaV3() {
        Alumno alumno = new Alumno();
        assertNotNull(alumno);
        AlumnoManager alumnoManager = new AlumnoManager();
         assertEquals((0), alumnoManager.calcularMedia());
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0, Sobresaliente adulto","Jose , 16, 4.0, Suspenso menor"})
    void calificarAlumno(String nombre, int edad, double notaMedia, String calificacion) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        assertEquals(calificacion, alumnoManager.clasificarAlumno(alumno));
    }

     @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0 "})
    void getAlumnos(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
         Alumno alumno2 = new Alumno("Jose", 16, 4.0);
        alumnoManager.agregarAlumno(alumno);
        alumnoManager.agregarAlumno(alumno2);
        ArrayList alumnos = new ArrayList<>();
        alumnos.add(alumno);
        alumnos.add(alumno2);
        assertEquals(alumnos,alumnoManager.getAlumnos());
    }

       @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0 "})
    void setAlumnos(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
         Alumno alumno2 = new Alumno("Jose", 16, 4.0);
         Alumno alumno3 = new Alumno("Toreto", 18, 6.0);
        ArrayList alumnos = new ArrayList<>();
        alumnos.add(alumno);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
           alumnoManager.setAlumnos(alumnos);
        assertEquals(alumnos,alumnoManager.getAlumnos());
    }

    @ParameterizedTest
    @CsvSource({"Sergio , 20, 9.0 "})
    void mostrarAlumnosAprobados(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        alumnoManager.mostrarAlumnosAprobados();
        assertEquals("Alumno aprobado: Sergio\n" ,salida.toString());

    }

    @ParameterizedTest
    @CsvSource({"Jose , 16, 4.0 "})
    void mostrarAlumnosSuspensos(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        alumnoManager.mostrarAlumnosSuspensos();
        assertEquals("Alumno suspenso: Jose\n" ,salida.toString());
    }
    @ParameterizedTest
    @CsvSource({"Jose , 16, 5.0 "})
    void mostrarAlumnosSuspensosV2(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        alumnoManager.mostrarAlumnosSuspensos();
        assertEquals("" ,salida.toString());
    }

    @ParameterizedTest
    @CsvSource({"Jose , 16, 4.0 "})
    void mostrarAlumnosAprobadosV2(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        alumnoManager.mostrarAlumnosAprobados();
        assertEquals("" ,salida.toString());
    }
}

