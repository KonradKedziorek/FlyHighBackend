package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Role;
import com.springdemo.flyhighproject.repo.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByName(String name){
        if(roleRepository.findByName(name).isPresent()){
            return roleRepository.findByName(name).get();
        }
        else{
            //coś
        }
        return null;
        //ToDo zabezpieczenie przed nullem
    }
}
