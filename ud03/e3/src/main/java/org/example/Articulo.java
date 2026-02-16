package org.example;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
    private String id;
    private String titulo;
    private TipoArticulo tipo;
    private String tema;
    private int numPaxinas;
    private final List<Autor> autores = new ArrayList<>();

    public Articulo(String id, String titulo, TipoArticulo tipo, String tema, int numPaxinas) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.tema = tema;
        this.numPaxinas = numPaxinas;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoArticulo getTipo() {
        return tipo;
    }

    public String getTema() {
        return tema;
    }

    public int getNumPaxinas() {
        return numPaxinas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipo(TipoArticulo tipo) {
        this.tipo = tipo;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setNumPaxinas(int numPaxinas) {
        this.numPaxinas = numPaxinas;
    }

    public void addAutor(Autor autor) {
        autores.add(autor);
    }
}
