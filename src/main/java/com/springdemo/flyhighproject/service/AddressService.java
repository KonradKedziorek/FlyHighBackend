package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Address;
import com.springdemo.flyhighproject.payload.SignUpRequest;
import com.springdemo.flyhighproject.repo.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {


    private AddressRepository addressRepository;


    public Address createAddress(SignUpRequest signUpRequest) {
        return addressRepository.save(Address.builder()
                        .country(signUpRequest.getCountry())
                        .city(signUpRequest.getCity())
                        .street(signUpRequest.getStreet())
                        .houseNumber(signUpRequest.getHouseNumber())
                        .zipCode(signUpRequest.getZipCode())
                        .build());
    }
}
