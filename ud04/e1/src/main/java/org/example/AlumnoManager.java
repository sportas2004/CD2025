package org.example;

/**
 * Clase en el cual se introduce el nombre de un Alumno Manager y se pueden añadir diferentes alumnos y comprobar si es mayor de 18
 * @author SergioP
 */
public class AlumnoManager {

    private static String nombre = "";

    /**
     * Get el cual se puede conseguir lo que contiene la variable nombre
     * @return nombre
     */
    public static String getNombre() {
        return nombre;
    }

    /**
     * Set el cual se puede modificar la variable nombre, pudiendo variar su valor
     * @param nombre
     */

    public static void setNombre(String nombre) {
        AlumnoManager.nombre = nombre;
    }

    public static int contador = 0;

    /**
     * Metodo el cual recibe un parametro String de un usuario y modifica el valor del nombre, ademas de aumentar el valor de contador
     * @param cadena1
     */

    public static void alumnoManager(String cadena1) {
        setNombre(cadena1);
        contador++;
    }

    /**
     * Metodo el cual añade alumnos al alumno manager, donde imprime por pantalla los resultados de los alumnos. Aparte de deteminar si es mayor o menor de edad
     * String la cual es el nombre del alumno
     * @param name
     * Int el cual hace referencia a la edad del alumno
     * @param edad
     * Double el cual hace referencia a la nota media obtenida del alumno
     * @param notaMedia
     */

    public void addAlumno(String name, int edad, double notaMedia) {
        if (edad > 18) {System.out.println("Mayor");} else {System.out.println("Menor");}
        for (int i = 0; i < 10; i++) {System.out.println(i + ":" + name + "-" + notaMedia);}
    }

    /**
     * Metodo de impresion del objeto AlumnoManager
     * @return "AlumnoManager{Nombre=" + nombre + ", contador=" + contador + "}"
     */
    @Override
    public String toString() {
        return "AlumnoManager{Nombre=" + nombre + ", contador=" + contador + "}";
    }
}

