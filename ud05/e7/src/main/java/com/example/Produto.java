package com.example;

public class Produto {
    private String nome = "";

    public String getNome() {
        return nome;
    }

    public void setNome(String nombre) {
        if(nombre.isEmpty()) throw new IllegalArgumentException("ESCRIBE ALGUN NOMBRE");
        this.nome = nombre;
    }

    private Double prezo = 0.0;

    public Double getPrezo() {
        return prezo;
    }

    public void setPrezo(Double prezo) {
        if(prezo<0) throw new IllegalArgumentException("NO SE PUEDE COLOCAR UN PRECIO NEGATIVO");
        this.prezo = prezo;
    }

    public Produto(String nombre, Double precio) {
        if(nombre==null) throw new IllegalArgumentException("NOMBRE NO PUEDE SER NULL");
        if(nombre.isEmpty()) throw new IllegalArgumentException("ESCRIBE ALGUN NOMBRE");
        this.nome = nombre;
        if(precio<0) throw new IllegalArgumentException("PRECIO NEGATIVO");

        this.prezo = precio;
    }
}
