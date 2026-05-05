package com.example;

import java.util.*;

public class CarrinhoCompra {

    private ArrayList<Produto> elementosCarrito = new ArrayList<>();

    public void engadirProduto(Produto obj) {
        elementosCarrito.add(obj);
    }

    private Double totalProductos=0.0;

    public void setTotalProductos(Double totalProductos) {
        this.totalProductos += totalProductos;
    }

    public int getNumeroProdutos(){return elementosCarrito.size();}

    public double calcularTotal() {
        this.elementosCarrito.forEach(it -> setTotalProductos(it.getPrezo()));
        Double temp = totalProductos;
        totalProductos = 0.0;
        return temp;
    }

    public void eliminarProduto(Produto obj) {
        for (int indice = 0; indice < elementosCarrito.size(); indice += 1) {
            if (elementosCarrito.get(indice) == obj) {
                elementosCarrito.remove(indice);
            }
        }

    }
}
