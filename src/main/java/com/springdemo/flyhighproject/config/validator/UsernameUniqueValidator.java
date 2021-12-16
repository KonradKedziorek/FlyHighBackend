package com.springdemo.flyhighproject.config.validator;

import com.springdemo.flyhighproject.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqueValidator implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void initialize(UniqueUsername unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        try{
            boolean exists = accountRepository.existsAccountByUsername(username);
            return !exists;
        }catch (NullPointerException nullPointerException){
            return true;
        }
    }
}
