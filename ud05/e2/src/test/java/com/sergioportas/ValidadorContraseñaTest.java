package com.sergioportas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

    public class ValidadorContraseñaTest {

        ValidadorContraseña validador=new ValidadorContraseña();

        @Test
        void testContraseñaDebeTenerAlMenosOchoCaracteres() {
            ValidadorContraseña validador = new ValidadorContraseña();
            assertFalse(validador.esValida("Ab1!")); // Demasiado corta
            assertTrue(validador.esValida("Abcd123!")); // Cumple con la longitud
        }

        @ParameterizedTest
        @CsvSource({"Ab1!,false", "Abcd123!,true"})
        void testContraseñaDebeTenerAlMenosOchoCaracteres(String contraseña, boolean resultadoEsperado) {
            assertEquals(resultadoEsperado, validador.esValida(contraseña));
        }

        @ParameterizedTest
        @CsvSource({"abcdefg1!,false", "Abcdefg1!,true"})
        void testContraseñaDebeContenerUnaMayúscula(String contraseña, boolean resultadoEsperado) {
            assertEquals(resultadoEsperado, validador.esValida(contraseña));
        }

        @ParameterizedTest
        @CsvSource({"Abcdefg1,false", "Abcdefg1!,true"})
        void testContraseñaDebeContenerUnCaracterEspecial(String contraseña, boolean resultadoEsperado) {
            assertEquals(resultadoEsperado, validador.esValida(contraseña));
        }

    }

