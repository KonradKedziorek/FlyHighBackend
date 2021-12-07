package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.repo.PlaneClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneClassService {

    @Autowired
    PlaneClassRepository planeClassRepository;
}
