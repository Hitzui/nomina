package com.dysconcsa.app.nomina.repository;

import com.dysconcsa.app.nomina.model.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICargoRepository extends JpaRepository<Cargos, Integer> {
    
}