package com.sistemas.embarcados.estacionamentos.model;
import java.util.Random;
public class GeradorStatus {
    public long gerandoValoresAleatorios(){
        Random gerador = new Random();
        return gerador.nextInt();
    }
}
