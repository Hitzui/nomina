package com.dysconcsa.app.nomina.service;

import com.dysconcsa.app.nomina.model.Horario;

import java.util.List;

public interface IHorarioService {
    List<Horario> findAllHorarioNow();
    Horario save(Horario horario);
    void delete(int idempleado, String fecha);
}
