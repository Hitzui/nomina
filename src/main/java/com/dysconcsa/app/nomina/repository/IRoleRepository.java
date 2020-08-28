/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.repository;

import com.dysconcsa.app.nomina.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jmigu
 */
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    
}
