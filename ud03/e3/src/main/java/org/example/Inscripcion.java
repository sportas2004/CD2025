package org.example;

import java.time.LocalDateTime;

public class Inscripcion {
    private String id;
    private EstadoInscripcion estado;
    private LocalDateTime dataRexistro;
    private Participante participante;
    private Conferencia conferencia;

    public Inscripcion(String id, Participante participante, Conferencia conferencia) {
        this.id = id;
        this.participante = participante;
        this.conferencia = conferencia;
        this.estado = EstadoInscripcion.PENDENTE;
        this.dataRexistro = LocalDateTime.now();
    }

    public String getId() { return id; }
    public EstadoInscripcion getEstado() { return estado; }
    public LocalDateTime getDataRexistro() { return dataRexistro; }
    public Participante getParticipante() { return participante; }
    public Conferencia getConferencia() { return conferencia; }

    public void confirmar() { this.estado = EstadoInscripcion.CONFIRMADA; }
    public void cancelar() { this.estado = EstadoInscripcion.CANCELADA; }

    public boolean estaActiva() {
        return estado != EstadoInscripcion.CANCELADA;
    }
}