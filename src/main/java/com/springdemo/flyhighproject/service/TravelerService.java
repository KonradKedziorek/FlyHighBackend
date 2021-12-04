package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.repo.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelerService {

    @Autowired
    TravelerRepository travelerRepository;
}
