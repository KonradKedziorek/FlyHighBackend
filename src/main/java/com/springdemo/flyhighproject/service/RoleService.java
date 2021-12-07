package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Role;
import com.springdemo.flyhighproject.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name);
        //ToDo zabezpieczenie przed nullem
    }
}
