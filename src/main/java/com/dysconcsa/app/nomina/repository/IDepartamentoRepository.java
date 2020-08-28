package com.dysconcsa.app.nomina.repository;

import com.dysconcsa.app.nomina.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer>{
    
}