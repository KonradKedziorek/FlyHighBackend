package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.repo.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {

    @Autowired
    PlaneRepository planeRepository;
}
