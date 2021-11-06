package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Account;
import com.springdemo.flyhighproject.model.CustomAccount;
import com.springdemo.flyhighproject.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

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



}
