package com.example;

import java.math.BigInteger;

/**
 * Clase la cual realiza el calculo fibonacci de un numero devolviendo el resultado
 * @author Sergio Portas Arcos
 */

public class Fibonacci {

    /**
     * Metodo que realiza el calculo de fibonacci apartir del numero que se envia
     * @param n Numero que se usara para calcular fibonacci
     * @return BigInteger
     * @throws Exception  "Error. El número tiene que ser >=0"
     */
    public BigInteger fibonacci(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Error. El número tiene que ser >=0");
        }

        if (n == 0) {
            return BigInteger.ZERO;
        }

        if (n == 1) {
            return BigInteger.ONE;
        }

        BigInteger anterior = BigInteger.ZERO;
        BigInteger actual = BigInteger.ONE;
        BigInteger resultado = BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            resultado = anterior.add(actual);
            anterior = actual;
            actual = resultado;
        }

        return actual;
    }
}
