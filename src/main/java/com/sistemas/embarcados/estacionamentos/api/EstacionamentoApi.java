package com.sistemas.embarcados.estacionamentos.api;

import com.sistemas.embarcados.estacionamentos.model.Vagas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public interface EstacionamentoApi {

    @GetMapping("/vagas")
    public ResponseEntity<List<Vagas>> getVagasSituacao();

}
