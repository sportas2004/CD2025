package org.example;

public class Autor {
    private String id;
    private String nome;
    private String afiliacion;
    private String email;

    public Autor(String id, String nome, String afiliacion, String email) {
        this.id = id;
        this.nome = nome;
        this.afiliacion = afiliacion;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}