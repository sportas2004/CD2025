package org.example;

public class Asistencia {
    private Rol rol;
    private boolean presente;
    private Inscripcion inscripcion;
    private Sesion sesion;

    public Asistencia(Rol rol, Inscripcion inscripcion, Sesion sesion) {
        this.rol = rol;
        this.inscripcion = inscripcion;
        this.sesion = sesion;
        this.presente = false;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean isPresente() {
        return presente;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void marcarPresente() {
        this.presente = true;
    }
}
