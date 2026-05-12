package com.example;

import java.util.*;

/**
 * Clase para añadir, eliminar Produtos del carrito
 * @author Sergio Portas Arcos
 */

public class CarrinhoCompra {

    private ArrayList<Produto> elementosCarrito = new ArrayList<>();

    /**
     * Metodo para añadir Produtos
     * @param obj Produto unitario
     */
    public void engadirProduto(Produto obj) {
        elementosCarrito.add(obj);
    }

    private Double totalProductos=0.0;

    /**
     * Metodo para modificar el precio total de los Produtos
     * @param totalProductos Precio total de Produtos
     */
    public void setTotalProductos(Double totalProductos) {
        this.totalProductos += totalProductos;
    }

    /**
     * Metodo para saber la cantida de Produtos del carrito
     * @return Numero de Produtos del carrito
     */
    public int getNumeroProdutos(){return elementosCarrito.size();}

    /**
     * Metodo para calcular el precio total de los Produtos
     * @return Precio total de Produtos
     */
    public double calcularTotal() {
        this.elementosCarrito.forEach(it -> setTotalProductos(it.getPrezo()));
        Double temp = totalProductos;
        totalProductos = 0.0;
        return temp;
    }

    /**
     * Metodo para eliminar un Produto
     * @param obj Produto que se quieres eliminar
     */
    public void eliminarProduto(Produto obj) {
        for (int indice = 0; indice < elementosCarrito.size(); indice += 1) {
            if (elementosCarrito.get(indice) == obj) {
                elementosCarrito.remove(indice);
            }
        }

    }
}
