package com.sistemas.embarcados.estacionamentos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalTime;
import java.util.Date;

@Entity
public class Vagas {
    @Id
    private long id;
    private boolean temCarro;
    private LocalTime tempoEstacionado;

    public LocalTime getTempoEstacionado() {
        return tempoEstacionado;
    }

    public void setTempoEstacionado(LocalTime tempoEstacionado) {
        this.tempoEstacionado = tempoEstacionado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isTemCarro() {
        return temCarro;
    }

    public void setTemCarro(boolean temCarro) {
        this.temCarro = temCarro;
    }
}
