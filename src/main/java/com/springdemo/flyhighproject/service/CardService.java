package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.repo.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
}
