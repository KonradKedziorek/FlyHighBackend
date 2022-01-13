package com.springdemo.flyhighproject.config.validator;

import com.springdemo.flyhighproject.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<UniqueEmail,String> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void initialize(UniqueEmail unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        try{
            boolean exists = accountRepository.existsAccountByEmail(email);
            return !exists;
        }catch (NullPointerException nullPointerException){
            return true;
        }
    }
}
