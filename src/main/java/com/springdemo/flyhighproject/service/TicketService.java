package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
}
