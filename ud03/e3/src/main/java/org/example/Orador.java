package org.example;

public class Orador extends Participante {
    private String afiliacion;

    public Orador(String id, String nome, String email, String afiliacion) {
        super(id, nome, email);
        this.afiliacion = afiliacion;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }
}
