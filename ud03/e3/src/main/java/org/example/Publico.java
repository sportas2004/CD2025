package org.example;

public class Publico extends Participante {
    private String organizacion;

    public Publico(String id, String nome, String email, String organizacion) {
        super(id, nome, email);
        this.organizacion = organizacion;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
}