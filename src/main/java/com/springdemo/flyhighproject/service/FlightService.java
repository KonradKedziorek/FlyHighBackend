package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Flight;
import com.springdemo.flyhighproject.repo.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    //@Autowired
    //private FlightRepository flightRepository;
    public final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void createFlight(Flight flight){ flightRepository.save(flight);}
}
