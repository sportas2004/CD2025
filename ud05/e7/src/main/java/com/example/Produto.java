package com.example;

/**
 * Clase para crear Produtos apartir de su nombre y precio
 *
 * @author Sergio Portas Arcos
 */

public class Produto {
    private String nome = "";

    /**
     * Metodo para obtener el nombre del Produto
     * @return Nombre del Produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo para modificar el nombre del produto y asegura que invalide colocar un nombre vacio
     * @param nombre Nombre nuevo que se quiera ponar al produto
     */
    public void setNome(String nombre) {
        if(nombre.isEmpty()) throw new IllegalArgumentException("ESCRIBE ALGUN NOMBRE");
        this.nome = nombre;
    }

    private Double prezo = 0.0;

    /**
     * Metodo para obtener el precio del produto
     * @return Precio del Produto
     */

    public Double getPrezo() {
        return prezo;
    }

    /**
     * Metodo para modificar el precio
     * @param prezo Precio del Produto
     */
    public void setPrezo(Double prezo) {
        if(prezo<0) throw new IllegalArgumentException("NO SE PUEDE COLOCAR UN PRECIO NEGATIVO");
        this.prezo = prezo;
    }

    /**
     * Constructor para crear un objeto Produto apartir de un nombre y precio,
     * lanzando exepciones cuando el nombre es null, nombre vacio o un precio negativo
     * @param nombre Nombre del Produto
     * @param precio Precio unitario del Produto
     */

    public Produto(String nombre, Double precio) {
        if(nombre==null) throw new IllegalArgumentException("NOMBRE NO PUEDE SER NULL");
        if(nombre.isEmpty()) throw new IllegalArgumentException("ESCRIBE ALGUN NOMBRE");
        this.nome = nombre;
        if(precio<0) throw new IllegalArgumentException("PRECIO NEGATIVO");

        this.prezo = precio;
    }
}
