package com.springdemo.flyhighproject.config.validator;

import com.springdemo.flyhighproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BankAccountUniqueValidator implements ConstraintValidator<UniqueBankAccount, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueBankAccount unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String bankaccount, ConstraintValidatorContext context) {
        try{
            boolean exists = userRepository.existsUserByBankAccount(bankaccount);
            return !exists;
        }catch (NullPointerException nullPointerException){
            return true;
        }
    }
}
