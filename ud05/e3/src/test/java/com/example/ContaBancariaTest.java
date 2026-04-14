package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    @Test
    void testContaBancariaConstructorPredefinidio() {
       ContaBancaria conta = new ContaBancaria();
       assertTrue(conta.getTitular().equals("Descoñecido"));
       assertTrue(conta.getSaldo()==0.0);
        assertTrue(conta.getNumeroOperacions()==0.0);
    }

    @ParameterizedTest
    @CsvSource({"Sergio,1000.0", "Jose,500.0"})
    void testContaBancariaRellenandoCampos(String titular, Double saldo) {
        ContaBancaria conta = new ContaBancaria(titular,saldo);
        assertTrue(conta.getTitular().equals(titular));
        assertTrue(conta.getSaldo()==saldo);
    }

    @ParameterizedTest
    @CsvSource({"1000.0, -1.0", "500.0,-2.0"})
    void testIngresoCuenta( Double saldoPositivo,Double saldoNegativo) {
        ContaBancaria conta = new ContaBancaria();
        conta.ingresar(saldoPositivo);
        assertTrue(conta.getSaldo()==saldoPositivo);
        conta.ingresar(saldoNegativo);
        assertFalse(conta.getSaldo()==saldoNegativo);
    }


    @ParameterizedTest
    @CsvSource({"1000.0, 200.0, true", "0.0, 200.0,false","-1.0, 200.0,false","200.0, -200.0,false"})
    void testRetirarCuenta( Double saldo,Double retiramos,Boolean esperado) {
        ContaBancaria conta = new ContaBancaria("Sergio",saldo);
        assertEquals(conta.retirar(retiramos),esperado);
    }

    @ParameterizedTest
    @CsvSource({"5.0,300.0, 4, 0.0", "5.0,300.0, 6, 2.7","5.0,300.0, 11 , 4.9" })
    void testComision( Double retiro,Double saldo,int operaciones,Double esperado) {
        ContaBancaria conta = new ContaBancaria("Sergio",saldo);
        for (int i=0;i<operaciones;i++){
            conta.retirar(retiro);
        }
        assertEquals(conta.calcularComision(),esperado);
    }


    @ParameterizedTest
    @CsvSource({"5.0,300.0, 4, 280.0", "5.0,300.0, 6,267.3","5.0,300.0, 11 , 240.1" })
    void testAplicarComision( Double retiro,Double saldo,int operaciones,Double esperado) {
        ContaBancaria conta = new ContaBancaria("Sergio",saldo);
        for (int i=0;i<operaciones;i++){
            conta.retirar(retiro);
        }
        conta.aplicarComision();
        assertEquals(conta.getSaldo(),esperado);
    }

    @ParameterizedTest
    @CsvSource({"Sergio","Marcos","David" })
    void testNombreTitular( String nombre) {
        ContaBancaria conta = new ContaBancaria();
        conta.setTitular(nombre);
        assertEquals(conta.getTitular(),nombre);
    }





}
