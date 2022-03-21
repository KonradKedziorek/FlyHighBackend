package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.*;
import com.springdemo.flyhighproject.payload.EditDataRequest;
import com.springdemo.flyhighproject.payload.SignUpRequest;
import com.springdemo.flyhighproject.payload.SignUpResponse;
import com.springdemo.flyhighproject.repo.AccountRepository;
import com.springdemo.flyhighproject.repo.AddressRepository;
import com.springdemo.flyhighproject.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  AddressService addressService;

    @Autowired
    private  AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AddressRepository addressRepository;

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

    public User updateUserData(EditDataRequest editDataRequest){
        User existingUser = userRepository.findUserByAccount_Username(SecurityContextHolder.getContext().getAuthentication().getName());
        existingUser.setName(editDataRequest.getName());
        existingUser.setMiddleName(editDataRequest.getMiddleName());
        existingUser.setSurname(editDataRequest.getSurname());
        existingUser.setBankAccount(editDataRequest.getBankAccount());

        Address existingAddress = addressRepository.findAddressByUserId(existingUser.getId());
        existingAddress.setCountry(editDataRequest.getCountry());
        existingAddress.setCity(editDataRequest.getCity());
        existingAddress.setStreet(editDataRequest.getStreet());
        existingAddress.setHouseNumber(editDataRequest.getHouseNumber());
        existingAddress.setZipCode(editDataRequest.getZipCode());

        Account existingAccount = accountRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        existingAccount.setPhoneNumber(editDataRequest.getPhoneNumber());
        existingAccount.setEmail(editDataRequest.getEmail());

        return userRepository.save(existingUser);
    }

}
