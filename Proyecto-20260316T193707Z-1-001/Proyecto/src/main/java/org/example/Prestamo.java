package org.example;

public class Prestamo {

   String fechaPrestamo="XX-XX-XX";

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    String fechaDevolucion="XX-XX-XX";

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    String isbn="XXXXXXX";

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    String idUsuario="XXXXX";

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    Prestamo(Libro objLibro, Usuario objUsuairo, String fechaPrestamo){
        if(objLibro.disponible){
           setIsbn(objLibro.isbn);
            setIdUsuario(objUsuairo.idUsuario);
            setFechaPrestamo(fechaPrestamo);
            objLibro.setDisponible(false);
            objUsuairo.prestamo(this);
        }else{
           throw new IllegalArgumentException("No esta disponible");
        }
    }

   public void devolucion(Libro objLibro,Usuario objUsuairo, String fechaDevolucion){
        setFechaDevolucion(fechaDevolucion);
        objLibro.setDisponible(true);
        objUsuairo.prestamo(this);
    }
}
