package com.sistemas.embarcados.estacionamentos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Vagas {
    @Id
    private long id;
    private boolean temCarro;

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
