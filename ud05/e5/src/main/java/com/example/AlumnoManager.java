package com.example;

import java.util.ArrayList;
   
/**
 * Gestiona una lista de alumnos.
 */
public class AlumnoManager {
    private static final Logger LOGGER = Logger.getLogger(AlumnoManager.class.getName());

    private List<Alumno> alumnos = new ArrayList<>();

    /**
     * Agrega un alumno si no es nulo.
     * @param a el alumno que se va a agregar
     */
    public void agregarAlumno(Alumno a) {
        if (a != null) {
            alumnos.add(a);
        }
    }

    /**
     * Busca un alumno por su nombre.
     * @param nombre el nombre que se va a buscar
     * @return el alumno encontrado o null si no existe
     */
    public Alumno buscarAlumnoPorNombre(String nombre) {
        for (Alumno a : alumnos) {
            if (a.getNombre().equals(nombre)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Calcula la nota media de todos los alumnos.
     * @return la media o 0 si no hay alumnos
     */
    public double calcularMedia() {
        double suma = 0;
        for (Alumno a : alumnos) {
            suma = suma + a.getNotaMedia();
        }
        if (alumnos.isEmpty()) {
            return 0;
        }
        return suma / alumnos.size();
    }

    /**
     * Clasifica un alumno segun su nota y edad.
     * @param a el alumno que se va a clasificar
     * @return la clasificacion del alumno
     */
    public String clasificarAlumno(Alumno a) {
        if (a == null) {
            return "Alumno nulo";
        }

        if (a.getNotaMedia() >= 9 && a.getEdad() >= 18) {
            return "Sobresaliente adulto";
        } else if (a.getNotaMedia() >= 9 && a.getEdad() < 18) {
            return "Sobresaliente menor";
        } else if (a.getNotaMedia() >= 7 && a.getEdad() >= 18) {
            return "Notable adulto";
        } else if (a.getNotaMedia() >= 7 && a.getEdad() < 18) {
            return "Notable menor";
        } else if (a.getNotaMedia() >= 5 && a.getEdad() >= 18) {
            return "Aprobado adulto";
        } else if (a.getNotaMedia() >= 5 && a.getEdad() < 18) {
            return "Aprobado menor";
        } else if (a.getEdad() >= 18) {
            return "Suspenso adulto";
        } else {
            return "Suspenso menor";
        }
    }

    /**
     * Muestra los alumnos aprobados.
     */
    public void mostrarAlumnosAprobados() {
        for (Alumno a : alumnos) {
            if (a.getNotaMedia() >= 5) {
                LOGGER.info(() -> "Alumno aprobado: " + a.getNombre());
            }
        }
    }

    /**
     * Muestra los alumnos suspensos.
     */
    public void mostrarAlumnosSuspensos() {
        for (Alumno a : alumnos) {
            if (a.getNotaMedia() < 5) {
                LOGGER.info(() -> "Alumno suspenso: " + a.getNombre());
            }
        }
    }

    /**
     * Obtiene la lista de alumnos.
     * @return la lista de alumnos
     */
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Establece la lista de alumnos.
     * @param alumnos la lista de alumnos
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
