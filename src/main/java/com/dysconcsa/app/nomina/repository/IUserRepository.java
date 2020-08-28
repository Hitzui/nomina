package com.dysconcsa.app.nomina.repository;

import com.dysconcsa.app.nomina.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<Users, Long> {

    public Users findByUsername(String username);
}
