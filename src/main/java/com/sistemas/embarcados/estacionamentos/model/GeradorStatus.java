package com.sistemas.embarcados.estacionamentos.model;
import java.util.Random;
public class GeradorStatus {
    public boolean gerandoTrueFalse(){
        Random gerador = new Random();
        int num = gerador.nextInt(2);
        return num == 1;
    }
    public long gerandoValoresAleatoriosData(){
        Random gerador = new Random();
        return gerador.nextInt(43200);
    }
}
