package com.sistemas.embarcados.estacionamentos.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryVagas extends CrudRepository<Vagas, String> {
    List<Vagas> findAll();
    Vagas findById(Long id);
}
