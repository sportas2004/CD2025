package org.example;


import java.util.ArrayList;


public class Usuario {

   String idUsuario="XXXXX";



    String nombre="default";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    String correo="XXXXXX@XXXX.com";

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    ArrayList<Prestamo> Prestamo= new ArrayList<>();

    public void prestamo(Prestamo obj){
        Prestamo.add(obj);
    }

    Usuario(String idUsuario,String nombre){
        this.idUsuario=idUsuario;
        this.nombre=nombre;
    }
}
