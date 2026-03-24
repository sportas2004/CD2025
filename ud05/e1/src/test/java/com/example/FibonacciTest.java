package com.example;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {


    @Test
    public void fibonacci0() throws Exception {
        Fibonacci obj = new Fibonacci();
        assertEquals( BigInteger.ZERO,obj.fibonacci(0));
    }

    @Test
    public void fibonacci1() throws Exception {
        Fibonacci obj = new Fibonacci();
        assertEquals( BigInteger.ONE,obj.fibonacci(1));
    }

    @Test
    public void fibonacciResultado() throws Exception {
        Fibonacci obj = new Fibonacci();
        assertEquals(new BigInteger("12586269025"),obj.fibonacci(50));
    }

    @Test
    public void fibonacciResultadoElevado() throws Exception {
        Fibonacci obj = new Fibonacci();
        assertEquals(obj.fibonacci(200), new BigInteger("280571172992510140037611932413038677189525"));
    }

    @Test
    public void fibonacciNumeroNegativo() throws Exception {
        Fibonacci obj = new Fibonacci();
        Exception exception = assertThrows(Exception.class, () -> {
            obj.fibonacci(-1);
        });

        assertEquals(exception.getMessage(), "Error. El número tiene que ser >=0");
    }

}
