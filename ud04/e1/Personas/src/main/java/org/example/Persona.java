package org.example;

/**
 * Clase Persona para conseguir datos personales
 * @author Sergio P
 */

public class Persona {

    private String nombre;
    private int edad;

    /**
     * @param nombre, el nombre que tiene el usuario
     * @param edad,   la edad que tiene el usuario
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * metodo get para actualizar la variable
     * @return nombre 
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * metodo set para la variable nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo get para actualizar la variable
     * @return edad 
     */

    public int getEdad() {
        return edad;
    }

    /**
     * metodo set para la variable edad
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * metodo para imprimir por pantalla el nombre y la edad
     */
    public void imprimirDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}