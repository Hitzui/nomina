/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.repository;

import com.dysconcsa.app.nomina.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author jmigu
 */
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

    List<Empleado> findAllByActivo(boolean active);
}
