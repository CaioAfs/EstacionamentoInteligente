package com.sistemas.embarcados.estacionamentos.controller;

import com.sistemas.embarcados.estacionamentos.model.GeradorStatus;
import com.sistemas.embarcados.estacionamentos.model.RepositoryVagas;
import com.sistemas.embarcados.estacionamentos.model.Vagas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EstacionamentoController {

    @Autowired
    RepositoryVagas vagasEstacionamento;

    @GetMapping("/vagas")
    public ResponseEntity<List<Vagas>> getVagasSituacao(){
        List<Vagas> listaVagasEstacionamento = vagasEstacionamento.findAll();

        if (listaVagasEstacionamento.isEmpty()){
            criandoVagasAleatorio();
            listaVagasEstacionamento = vagasEstacionamento.findAll();
        }else {
            gerandoNovosStatusVagas();
        }
        return new ResponseEntity<List<Vagas>>(listaVagasEstacionamento, HttpStatus.OK);
    }

    //Metodos proprios
    public void gerandoNovosStatusVagas(){

        GeradorStatus geradorNumeros = new GeradorStatus();
        for (long i = 1; i <= 10; i++){
            Vagas atualizaVagas = vagasEstacionamento.findById(i);
            boolean statusVaga = (geradorNumeros.gerandoValoresAleatorios() % 2 == 0) ? true : false;
            atualizaVagas.setTemCarro(statusVaga);
            vagasEstacionamento.save(atualizaVagas);
        }

    }
    public void criandoVagasAleatorio(){
        GeradorStatus geradorNumeros = new GeradorStatus();

        for (long i = 1; i <= 10; i++){
            boolean statusVaga = (geradorNumeros.gerandoValoresAleatorios() % 2 == 0) ? true : false;
            Vagas novaVagas = new Vagas();
            novaVagas.setId(i);
            novaVagas.setTemCarro(statusVaga);
            vagasEstacionamento.save(novaVagas);
        }
    }
}
