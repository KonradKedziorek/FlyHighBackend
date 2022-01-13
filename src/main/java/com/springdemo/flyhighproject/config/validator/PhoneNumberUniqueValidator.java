package com.springdemo.flyhighproject.config.validator;

import com.springdemo.flyhighproject.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberUniqueValidator implements ConstraintValidator<UniquePhoneNumber,String> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void initialize(UniquePhoneNumber unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        try{
            boolean exists = accountRepository.existsAccountByPhoneNumber(phoneNumber);
            return !exists;
        }catch (NullPointerException nullPointerException){
            return true;
        }
    }
}
