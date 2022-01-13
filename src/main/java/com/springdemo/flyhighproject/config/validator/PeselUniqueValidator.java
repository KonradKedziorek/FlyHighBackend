package com.springdemo.flyhighproject.config.validator;

import com.springdemo.flyhighproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselUniqueValidator implements ConstraintValidator<UniquePesel, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniquePesel unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String pesel, ConstraintValidatorContext context) {
        try{
            boolean exists = userRepository.existsUserByPesel(pesel);
            return !exists;
        }catch (NullPointerException nullPointerException){
            return true;
        }
    }
}
