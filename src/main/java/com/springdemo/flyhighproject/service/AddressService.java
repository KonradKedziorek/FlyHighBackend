package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
}
