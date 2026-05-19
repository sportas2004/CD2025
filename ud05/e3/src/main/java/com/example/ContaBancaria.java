package com.example;

/**
 * Representa una cuenta bancaria con titular, saldo y contador de operaciones.
 */
public class ContaBancaria {

    private String titular;
    private double saldo;
    private int numeroOperacions;

    /**
     * Crea una cuenta bancaria sin titular conocido y con saldo cero.
     */
    public ContaBancaria() {
        this.titular = "Descoñecido";
        this.saldo = 0.0;
        this.numeroOperacions = 0;
    }

    /**
     * Crea una cuenta bancaria con titular y saldo inicial.
     *
     * @param titular nombre del titular de la cuenta
     * @param saldoInicial saldo inicial disponible
     */
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.numeroOperacions = 0;
    }

    /**
     * Devuelve el titular de la cuenta.
     *
     * @return titular de la cuenta
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Modifica el titular de la cuenta.
     *
     * @param titular nuevo titular
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Devuelve el saldo actual.
     *
     * @return saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Devuelve el número de operaciones realizadas.
     *
     * @return número de operaciones
     */
    public int getNumeroOperacions() {
        return numeroOperacions;
    }

    /**
     * Ingresa una cantidad positiva y aumenta el contador de operaciones.
     *
     * @param cantidade cantidad a ingresar
     */
    public void ingresar(double cantidade) {
        if (cantidade > 0) {
            saldo += cantidade;
            numeroOperacions++;
        }
    }

    /**
     * Retira una cantidad positiva si existe saldo suficiente.
     *
     * @param cantidade cantidad a retirar
     * @return true si el retiro se realiza correctamente
     */
    public boolean retirar(double cantidade) {
        if (cantidade > 0 && saldo >= cantidade) {
            saldo -= cantidade;
            numeroOperacions++;
            return true;
        }
        return false;
    }

    /**
     * Calcula la comisión según el número de operaciones.
     *
     * @return importe de la comisión
     */
    public double calcularComision() {
        if (numeroOperacions < 5) {
            return 0;
        } else if (numeroOperacions <= 10) {
            return saldo * 0.01;
        } else {
            return saldo * 0.02;
        }
    }

    /**
     * Aplica la comisión calculada al saldo actual.
     */
    public void aplicarComision() {
        double comision = calcularComision();
        saldo -= comision;
    }
}
