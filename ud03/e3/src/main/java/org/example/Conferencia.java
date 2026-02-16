package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conferencia {
    private String id;
    private String nome;
    private String lugar;
    private LocalDate dataInicio;
    private LocalDate dataFin;

    private final List<Sesion> sesions = new ArrayList<>();
    private final List<Inscripcion> inscricions = new ArrayList<>();

    public Conferencia(String id, String nome, String lugar, LocalDate dataInicio, LocalDate dataFin) {
        this.id = id;
        this.nome = nome;
        this.lugar = lugar;
        this.dataInicio = dataInicio;
        this.dataFin = dataFin;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLugar() {
        return lugar;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFin() {
        return dataFin;
    }

    public List<Sesion> getSesions() {
        return sesions;
    }

    public List<Inscripcion> getInscricions() {
        return inscricions;
    }

    public void addSesion(Sesion s) {
            sesions.add(s);
    }

    public void rexistrar(Inscripcion i) {
            inscricions.add(i);
    }
}