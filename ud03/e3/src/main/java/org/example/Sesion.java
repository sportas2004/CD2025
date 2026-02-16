package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sesion {
    private String id;
    private String titulo;
    private LocalDateTime inicio;
    private String sala;

    private Conferencia conferencia; // pertence a 1 conferencia
    private final List<Articulo> artigos = new ArrayList<>();
    private final List<Asistencia> asistencias = new ArrayList<>();

    public Sesion(String id, String titulo, LocalDateTime inicio, String sala, Conferencia conferencia) {
        this.id = id;
        this.titulo = titulo;
        this.inicio = inicio;
        this.sala = sala;
        this.conferencia = conferencia;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public String getSala() {
        return sala;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public List<Articulo> getArtigos() {
        return artigos;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void addArticulo(Articulo a) {
        if (a != null && !artigos.contains(a)) {
            artigos.add(a);
        }
    }

    public void engadirAsistencia(Asistencia a) {
        Inscripcion ins = a.getInscripcion();
        if (ins == null || ins.getConferencia() != this.conferencia) {
            throw new IllegalArgumentException("A inscrición non pertenece a esta conferencia.");
        }
        if (ins.getEstado() == EstadoInscripcion.CANCELADA) {
            throw new IllegalStateException("A inscrición está cancelada.");
        }
        asistencias.add(a);
    }
}