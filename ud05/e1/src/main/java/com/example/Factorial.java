package com.example;

import java.math.BigInteger;

/**
 * Clase la cual devuelve el factorial de un numero
 * @author Sergio Portas Arcos
 */

public class Factorial {

    /**
     * Metodo que realiza el calculo factorial apartir del numero que se envia
     * @param n Numero que se usa para el calculo del factorial
     * @return BigInteger
     * @throws Exception "Error. El número tiene que ser >=0"
     */

    public BigInteger factorial(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Error. El número tiene que ser >=0");
        }

        BigInteger resultado = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        return resultado;
    }
}
