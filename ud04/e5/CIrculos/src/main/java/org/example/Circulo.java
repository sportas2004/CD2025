package org.example;

/**
 * Clase Circulo la cual se realizan diferentes calculos respecto a esta figura
 * @author Sergio P
 */
public class Circulo {
    private int x;
    private int y;
    private double radio;

    /**
     * Metodo Circulo para establecer valores a los parametros
     *
     * @param valorX: Dimensiones de x
     * @param valorY: Dimensiones de y
     * @param valorRadio: Valor que tiene el radio
     */
    public Circulo(int valorX, int valorY, double valorRadio) {
        establecerX(valorX);
        establecerY(valorY);
        establecerRadio(valorRadio);
    }

    /**
     * Metodo set  para la dimension x
     * @param valorX
     */

    public void establecerX(int valorX) {
        x = valorX;
    }

    /**
     * Metodo get para la dimension x
     * @return x
     */

    public int obtenerX() {
        return x;
    }

    /**
     * Metodo set para la dimension y
     *
     * @param valorY
     */
    public void establecerY(int valorY) {
        y = valorY;
    }

    /**
     * Metodo get para la dimension y
     *
     * @return y
     */

    public int obtenerY() {
        return y;
    }

    /**
     * Metodo set para definir el radio del circulo
     * @param valorRadio
     */

    public void establecerRadio(double valorRadio) {

        radio = (valorRadio < 0.0 ? 0.0 : valorRadio);
    }

    /**
     * Metodo get para las dimensiones del radio
     *
     * @return radio
     */
    public double obtenerRadio() {
        return radio;
    }

    /**
     * Metodo para calcular el diametodo Circulo para establecer valores a los parametros

Parameters:etros apartir del radio
     *
     * @return (radio*2)
     */

    public double obtenerDiametro() {
        return radio * 2;
    }

    /**
     * Metodo para calcular la circunferencia
     *
     * @return Math.PI * obtenerDiametro()
     */
    public double obtenerCircunferencia() {
        return Math.PI * obtenerDiametro();
    }

    /**
     * Metodo para calcular el area
     *
     * @return Math.PI * radio * radio
     */
    public double obtenerArea() {
        return Math.PI * radio * radio;
    }

    /**
     * Metodo para imprimir el objeto circulo
     *
     * @return "Centro = [" + x + "," + y + "]; Radio = " + radio
     */
    @Override
    public String toString() {
        return "Centro = [" + x + "," + y + "]; Radio = " + radio;
    }
}