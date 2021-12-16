package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    Role findByName(String name);
    Role findById(long id);
    Role deleteById(long id);
    Role deleteByName(String name);

    Optional<Role> findByName(String name);

}
