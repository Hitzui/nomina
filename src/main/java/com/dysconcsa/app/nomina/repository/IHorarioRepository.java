package com.dysconcsa.app.nomina.repository;

import com.dysconcsa.app.nomina.model.Empleado;
import com.dysconcsa.app.nomina.model.Horario;
import com.dysconcsa.app.nomina.model.HorarioPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IHorarioRepository extends JpaRepository<Horario, HorarioPK> {

    List<Horario> findByFechaEmpleado(Empleado empleado, LocalDate desde, LocalDate hasta);

    Horario findByHorarioPKAndEmpleado(HorarioPK horarioPK, Empleado empleado);

    @Modifying
    @Query(value = "delete from Horario h where h.empleado.id=?1 and h.horarioPK.fecha =?2")
    void deleteByHorarioPK(int idempleado, LocalDate fecha);
}
