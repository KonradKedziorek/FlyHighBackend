package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Account;
import com.springdemo.flyhighproject.model.CustomAccount;
import com.springdemo.flyhighproject.model.Role;
import com.springdemo.flyhighproject.model.User;
import com.springdemo.flyhighproject.payload.SignUpRequest;
import com.springdemo.flyhighproject.repo.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    private final RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(s);
        if(account == null){
            throw new UsernameNotFoundException("Username "+s+" not found.");
        }

        return new CustomAccount(account);
    }

    public void addAccount(Account account){
        accountRepository.save(account);
    }

    public Account createAccount(SignUpRequest signUpRequest, User user){
        Role role = roleService.findByName("ROLE_USER");

        Set<Role> roleSet = new HashSet<Role>(List.of(role));

        return accountRepository.save(Account.builder()
                .username(signUpRequest.getUsername())
                .password(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()))
                .phoneNumber(signUpRequest.getPhoneNumber())
                .email(signUpRequest.getEmail())
                .user(user)
                .roles(roleSet)
                .build());
    }

    public void updateResetPasswordToken(String token, Account account){
        account.setResetPasswordToken(token);
        accountRepository.save(account);
    }

    public Account getAccountByResetPasswordToken(String token){
        return accountRepository.findByResetPasswordToken(token);
    }

    public void updatePassword(String token, String newPassword, String repeatedNewPassword){

        Account account = accountRepository.findByResetPasswordToken(token);

        if(newPassword.equals(repeatedNewPassword)){
            System.out.println("new paasword " + newPassword);
            System.out.println("repeated password " + repeatedNewPassword);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(newPassword);
            account.setPassword(encodedPassword);
            account.setResetPasswordToken(null);
            accountRepository.save(account);
        }
    }

}
