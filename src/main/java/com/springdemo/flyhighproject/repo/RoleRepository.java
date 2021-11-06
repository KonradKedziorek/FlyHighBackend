package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
