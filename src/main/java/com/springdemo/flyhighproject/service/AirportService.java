package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.repo.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    @Autowired
    AirportRepository airportRepository;
}
