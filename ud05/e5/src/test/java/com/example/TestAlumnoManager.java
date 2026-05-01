package com.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

 class TestAlumnoManager {

    private String capturarLog(Runnable accion) {
        Logger logger = Logger.getLogger(AlumnoManager.class.getName());
        StringBuilder salida = new StringBuilder();
        Handler handler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                salida.append(record.getMessage()).append('\n');
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() {
            }
        };
        boolean useParentHandlers = logger.getUseParentHandlers();
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        try {
            accion.run();
        } finally {
            logger.removeHandler(handler);
            logger.setUseParentHandlers(useParentHandlers);
        }
        return salida.toString();
    }

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
    void buscarAlumnoNoEncontrado() {
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(new Alumno("Sergio", 20, 9.0));
        assertNull(alumnoManager.buscarAlumnoPorNombre("NoExiste"));
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
    @CsvSource({
        "Sergio, 20, 9.0, Sobresaliente adulto",
        "Jose, 16, 9.0, Sobresaliente menor",
        "Ana, 20, 8.0, Notable adulto",
        "Luis, 16, 8.0, Notable menor",
        "Maria, 20, 6.0, Aprobado adulto",
        "Pedro, 16, 6.0, Aprobado menor",
        "Juan, 20, 4.0, Suspenso adulto",
        "Teresa, 16, 4.0, Suspenso menor"
    })
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
        String salida = capturarLog(alumnoManager::mostrarAlumnosAprobados);
        assertEquals("Alumno aprobado: Sergio\n" ,salida);

    }

    @ParameterizedTest
    @CsvSource({"Jose , 16, 4.0 "})
    void mostrarAlumnosSuspensos(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        String salida = capturarLog(alumnoManager::mostrarAlumnosSuspensos);
        assertEquals("Alumno suspenso: Jose\n" ,salida);
    }
    @ParameterizedTest
    @CsvSource({"Jose , 16, 5.0 "})
    void mostrarAlumnosSuspensosV2(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        String salida = capturarLog(alumnoManager::mostrarAlumnosSuspensos);
        assertEquals("" ,salida);
    }

    @ParameterizedTest
    @CsvSource({"Jose , 16, 4.0 "})
    void mostrarAlumnosAprobadosV2(String nombre, int edad, double notaMedia) {
        Alumno alumno = new Alumno(nombre, edad, notaMedia);
        AlumnoManager alumnoManager = new AlumnoManager();
        alumnoManager.agregarAlumno(alumno);
        String salida = capturarLog(alumnoManager::mostrarAlumnosAprobados);
        assertEquals("" ,salida);
    }
}

