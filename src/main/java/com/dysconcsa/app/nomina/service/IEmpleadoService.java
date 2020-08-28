package com.dysconcsa.app.nomina.service;

import com.dysconcsa.app.nomina.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
    List<Empleado> findAll();
    Empleado save(Integer id,Empleado empleado);
    Optional<Empleado> findById(Integer id);
    boolean delete(Integer id);
    List<Empleado> findAllByActivo();
}