package com.sistemas.embarcados.estacionamentos.controller;

import com.sistemas.embarcados.estacionamentos.model.GeradorStatus;
import com.sistemas.embarcados.estacionamentos.repository.RepositoryVagas;
import com.sistemas.embarcados.estacionamentos.model.Vagas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api")
public class EstacionamentoController {

    @Autowired
    RepositoryVagas vagasEstacionamento;

    @GetMapping("/vagas")
    public ResponseEntity<List<Vagas>> getVagasSituacao(){
        List<Vagas> listaVagasEstacionamento = vagasEstacionamento.findAll();

        gerandoNovosStatusVagas();
        return new ResponseEntity<List<Vagas>>(listaVagasEstacionamento, HttpStatus.OK);
    }

    //Metodos proprios
    @Async
    @Transactional
    public CompletableFuture<Void> gerandoNovosStatusVagas(){
        GeradorStatus geradorNumeros = new GeradorStatus();
        List<Vagas> vagasAtualizadas = vagasEstacionamento.findAll();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Vagas atualizaVagas : vagasAtualizadas){
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                boolean statusVaga = (geradorNumeros.gerandoTrueFalse());
                LocalTime tempo = LocalTime.MIN.plusSeconds(geradorNumeros.gerandoValoresAleatoriosData());
                atualizaVagas.setTempoEstacionado(tempo);

                if(statusVaga){
                    atualizaVagas.setTempoEstacionado(null);
                }

                atualizaVagas.setTemCarro(statusVaga);
            });
            futures.add(future);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        return allFutures.thenRunAsync(() -> vagasEstacionamento.saveAllAndFlush(vagasAtualizadas));
    }
}
