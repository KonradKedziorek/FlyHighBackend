package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.*;
import com.springdemo.flyhighproject.payload.SignUpRequest;
import com.springdemo.flyhighproject.payload.SignUpResponse;
import com.springdemo.flyhighproject.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  AddressService addressService;

    @Autowired
    private  AccountService accountService;

    public SignUpResponse saveUser(SignUpRequest signUpRequest) {

        Address address = addressService.createAddress(signUpRequest);

        User user = createUser(signUpRequest, address);

        Account account = accountService.createAccount(signUpRequest, user);

        return SignUpResponse.builder()
                .email(account.getEmail())
                .username(account.getUsername())
                .build();
    }

    public User createUser(SignUpRequest signUpRequest, Address address) {
        return userRepository.save(User.builder()
                .pesel(signUpRequest.getPesel())
                .name(signUpRequest.getName())
                .middleName(signUpRequest.getMiddleName())
                .surname(signUpRequest.getSurname())
                .bankAccount(signUpRequest.getBankAccount())
                .address(address)
                .build());
    }
}
