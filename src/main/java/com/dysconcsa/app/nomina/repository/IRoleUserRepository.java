/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.repository;

import com.dysconcsa.app.nomina.model.RoleUser;
import com.dysconcsa.app.nomina.model.RoleUserPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author jmigu
 */
public interface IRoleUserRepository extends CrudRepository<RoleUser, RoleUserPK> {
    List<RoleUser> findByIduser(Integer iduser);
}
