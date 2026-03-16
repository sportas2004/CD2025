package org.example;

/**
 * @author Sergio Portas Arcos
 */
public class Libro {

    String isbn = "XXXXXXX";

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    String Titulo = "default";

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    String autor = "default";

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    int añoPublicacion = 0;

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    boolean disponible = false;

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    Libro(String isbn, int añoPublicacion, boolean disponible) {
        this.isbn = isbn;
        this.añoPublicacion = añoPublicacion;
        this.disponible = disponible;
    }
}
