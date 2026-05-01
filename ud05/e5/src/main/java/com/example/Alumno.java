package com.example;

/**
 * Representa un alumno con nombre, edad y nota media.
 */
 class Alumno {
    private String nombre;
    private int edad;
    private double notaMedia;

    /**
     * Constructor por defecto.
     */
    Alumno() {

    }

    /**
     * Constructor con parametros.
     * @param nombre el nombre
     * @param edad la edad
     * @param notaMedia la nota media
     */
    Alumno(String nombre, int edad, double notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

    /**
     * Obtiene el nombre.
     * @return el nombre
     */
    String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     * @param nombre el nombre
     */
    void setNombre(String nombre) {
        this.nombre = nombre;   
    }

    /**
     * Obtiene la edad.
     * @return la edad
     */
    int getEdad() {
        return edad;
    }

    /**
     * Establece la edad.
     * @param edad la edad
     */
    void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la nota media.
     * @return la nota media
     */
    double getNotaMedia() {
        return notaMedia;
    }

    /**
     * Establece la nota media.
     * @param notaMedia la nota media
     */
    void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
}
