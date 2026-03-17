package org.example;

/**
 * Gestiona el nombre del alumno actual y permite mostrar informacion basica
 * sobre un alumno.
 *
 * @author SergioP
 */
public class AlumnoManager {

    private static final int MAYORIA_EDAD = 18;
    private static final int REPETICIONES_IMPRESION = 10;

    private static String nombre = "";
    public static int contador = 0;

    /**
     * Devuelve el nombre almacenado.
     *
     * @return nombre actual
     */
    public static String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre almacenado.
     *
     * @param nombre nuevo nombre
     */
    public static void setNombre(String nombre) {
        AlumnoManager.nombre = nombre;
    }

    /**
     * Guarda el nombre recibido y aumenta el contador de altas.
     *
     * @param cadena1 nombre del alumno
     */
    public static void alumnoManager(String cadena1) {
        setNombre(cadena1);
        contador++;
    }

    /**
     * Muestra si el alumno es mayor de edad y lista su nombre con la nota media.
     *
     * @param name nombre del alumno
     * @param edad edad del alumno
     * @param notaMedia nota media del alumno
     */
    public void addAlumno(String name, int edad, double notaMedia) {
        if (edad > MAYORIA_EDAD) {
            System.out.println("Mayor");
        } else {
            System.out.println("Menor");
        }

        for (int i = 0; i < REPETICIONES_IMPRESION; i++) {
            System.out.println(i + ":" + name + "-" + notaMedia);
        }
    }

    /**
     * Devuelve una representacion textual del gestor.
     *
     * @return texto con el nombre y el contador
     */
    @Override
    public String toString() {
        return "AlumnoManager{nombre=" + nombre + ", contador=" + contador + "}";
    }
}
