package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.*;
import com.springdemo.flyhighproject.payload.SignUpRequest;
import com.springdemo.flyhighproject.payload.SignUpResponse;
import com.springdemo.flyhighproject.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AddressService addressService;

    private final AccountService accountService;

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
