package com.example;

 class Alumno {
    private String nombre;
    private int edad;
    private double notaMedia;

 Alumno() {

    }

Alumno(String nombre, int edad, double notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

String getNombre() {
        return nombre;
    }

void setNombre(String nombre) {
        this.nombre = nombre;   
    }

  int getEdad() {
        return edad;
    }

void setEdad(int edad) {
        this.edad = edad;
    }

 double getNotaMedia() {
        return notaMedia;
    }

void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
}