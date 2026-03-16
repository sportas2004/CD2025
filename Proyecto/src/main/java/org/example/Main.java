package org.example;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("0001", 1900, true);
        Usuario usuario1 = new Usuario("0001", "Sergio");
        Prestamo prestamo1 = new Prestamo(libro1, usuario1, "16-03-2026");
     //   Usuario usuario2 = new Usuario("0002", "Gloria");
     //  Prestamo prestamo2 = new Prestamo(libro1, usuario2, "17-03-2026");
    }
}

