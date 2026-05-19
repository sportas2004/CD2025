package com.example;

/**
 * Gestiona las notas de un alumno y calcula estadísticas básicas.
 */
public class XestorNotas {

    private String alumno;
    private double[] notas;

    /**
     * Crea un gestor sin alumno identificado y sin notas.
     */
    public XestorNotas() {
        this.alumno = "Anonimo";
        this.notas = new double[0];
    }

    /**
     * Crea un gestor con alumno y lista de notas.
     *
     * @param alumno nombre del alumno
     * @param notas notas del alumno
     */
    public XestorNotas(String alumno, double[] notas) {
        this.alumno = alumno;
        this.notas = notas;
    }

    /**
     * Devuelve el nombre del alumno.
     *
     * @return nombre del alumno
     */
    public String getAlumno() {
        return alumno;
    }

    /**
     * Modifica el nombre del alumno.
     *
     * @param alumno nuevo nombre del alumno
     */
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    /**
     * Devuelve las notas registradas.
     *
     * @return array de notas
     */
    public double[] getNotas() {
        return notas;
    }

    /**
     * Modifica las notas registradas.
     *
     * @param notas nuevas notas
     */
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    /**
     * Calcula la media de las notas.
     *
     * @return media de las notas o cero si no hay notas
     */
    public double calcularMedia() {
        if (notas.length == 0) {
            return 0;
        }

        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }

        return suma / notas.length;
    }

    /**
     * Calcula la nota máxima.
     *
     * @return nota máxima o cero si no hay notas
     */
    public double calcularMaximo() {
        if (notas.length == 0) {
            return 0;
        }

        double max = notas[0];
        for (double nota : notas) {
            if (nota > max) {
                max = nota;
            }
        }

        return max;
    }

    /**
     * Indica si el alumno está aprobado según su media.
     *
     * @return true si la media es mayor o igual que cinco
     */
    public boolean estaAprobado() {
        return calcularMedia() >= 5;
    }

    /**
     * Cuenta las notas suspensas.
     *
     * @return número de notas menores que cinco
     */
    public int contarSuspensos() {
        int contador = 0;
        for (double nota : notas) {
            if (nota < 5) {
                contador++;
            }
        }
        return contador;
    }
}
