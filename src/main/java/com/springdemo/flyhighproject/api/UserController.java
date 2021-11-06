package com.springdemo.flyhighproject.api;


import com.springdemo.flyhighproject.model.Account;
import com.springdemo.flyhighproject.model.Role;
import com.springdemo.flyhighproject.service.AccountService;
import com.springdemo.flyhighproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String test(){
        return "Hello user";
    }

    @GetMapping("/username")
    public String userInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @PostMapping("/add")
    public void addUser(){

        Account account = new Account();
        account.setUsername("Justyna");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        account.setPassword(bCryptPasswordEncoder.encode("niemahasla"));
        account.setPhoneNumber("65464646");
        account.setEmail("justyna@wp.pl");
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName("USER"));
        account.setRoles(roles);
        accountService.addAccount(account);
    }
}
