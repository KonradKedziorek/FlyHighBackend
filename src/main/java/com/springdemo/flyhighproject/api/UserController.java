package com.springdemo.flyhighproject.api;


import com.springdemo.flyhighproject.model.Account;
import com.springdemo.flyhighproject.model.Role;
import com.springdemo.flyhighproject.payload.EditDataRequest;
import com.springdemo.flyhighproject.payload.SignUpRequest;
import com.springdemo.flyhighproject.service.AccountService;
import com.springdemo.flyhighproject.service.EmailService;
import com.springdemo.flyhighproject.service.RoleService;
import com.springdemo.flyhighproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@Validated
@CrossOrigin
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

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
    public void addUser(@RequestParam("username") String username, @RequestParam("role") String role){

        Account account = new Account();
        account.setUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        account.setPassword(bCryptPasswordEncoder.encode("123"));
        account.setPhoneNumber("65464646");
        account.setEmail("justyna@wp.pl");
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(role));
        account.setRoles(roles);
        accountService.addAccount(account);
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> registration(@Valid @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(userService.saveUser(signUpRequest));
    }

    @PostMapping("/saveChangedData")
    public void saveChangedData(@RequestBody EditDataRequest editDataRequest){
        userService.updateUserData(editDataRequest);
    }

}
