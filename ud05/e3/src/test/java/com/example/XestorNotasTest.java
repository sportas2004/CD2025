package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

public class XestorNotasTest {


    @ParameterizedTest
    @CsvSource({"Sergio","Marcos","David" })
    void testNombreTitular( String nombre) {
        XestorNotas gestor = new XestorNotas();
        gestor.setAlumno(nombre);
        assertEquals(gestor.getAlumno(),nombre);
    }

    @Test
    void testXestorNotasConstructorPredefinidio() {
        XestorNotas gestor = new XestorNotas();
        assertEquals(gestor.getAlumno(),"Anonimo");
        assertArrayEquals(gestor.getNotas(),new double[0]);
    }

    @Test
    void testXestorNotasConstructorRellenandoCampos() {
        XestorNotas gestor = new XestorNotas("Sergio",new double[]{10.0,9.74});
        assertEquals(gestor.getAlumno(),"Sergio");
        assertArrayEquals(gestor.getNotas(),new double[]{10.0,9.74});

        XestorNotas gestor2 = new XestorNotas("Jose",new double[]{-2.0,1});
        assertEquals(gestor2.getAlumno(),"Jose");
        assertArrayEquals(gestor2.getNotas(),new double[]{-2.0,1});
    }

    @Test
    void testXestorNotasCalcularMedia() {
        XestorNotas gestor = new XestorNotas("Sergio",new double[]{});
        assertEquals(gestor.calcularMedia(),0);

        XestorNotas gestor1 = new XestorNotas("Sergio",new double[]{10.0,10.0});
        assertEquals(gestor1.calcularMedia(),10);
    }

    @Test
    void testXestorNotasCalcularMaximo() {
        XestorNotas gestor = new XestorNotas("Sergio",new double[]{});
        assertEquals(gestor.calcularMaximo(),0);

        XestorNotas gestor1 = new XestorNotas("Sergio",new double[]{10.0,9.0});
        assertEquals(gestor1.calcularMaximo(),10);

        XestorNotas gestor2 = new XestorNotas("Miguel",new double[]{2.75,2.3,1.2,3.2});
        assertEquals(gestor2.calcularMaximo(),3.2);
    }

    @Test
    void testXestorNotasComprobacionAprobado() {
        XestorNotas gestor = new XestorNotas("Sergio",new double[]{});
        assertEquals(gestor.estaAprobado(),false);

        XestorNotas gestor1 = new XestorNotas("Sergio",new double[]{10.0,10.0});
        assertEquals(gestor1.estaAprobado(),true);
    }

    @Test
    void testXestorNotasContarSuspensas() {
        XestorNotas gestor2 = new XestorNotas("Sergio",new double[]{});
        assertEquals(gestor2.contarSuspensos(),0);

        XestorNotas gestor = new XestorNotas("Miguel",new double[]{2.75,2.3,1.2,3.2});
        assertEquals(gestor.contarSuspensos(),4);

        XestorNotas gestor1 = new XestorNotas("Sergio",new double[]{10.0,10.0});
        assertEquals(gestor1.contarSuspensos(),0);
    }

    @Test
    void testXestorNotassetNotas() {
        XestorNotas gestor2 = new XestorNotas("Sergio",new double[]{});
        gestor2.setNotas(new double[]{10.0,10.0});
        assertArrayEquals(gestor2.getNotas(),new double[]{10.0,10.0});

        XestorNotas gestor = new XestorNotas("Miguel",new double[]{2.75,2.3,1.2,3.2});
        gestor2.setNotas(new double[]{2.75,2.3,1.2,3.2});
        assertArrayEquals(gestor2.getNotas(),new double[]{2.75,2.3,1.2,3.2});

    }

}
