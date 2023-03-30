package com.sistemas.embarcados.estacionamentos.repository;

import com.sistemas.embarcados.estacionamentos.model.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryVagas extends JpaRepository<Vagas, String> {
    List<Vagas> findAll();
    Vagas findById(Long id);
}
