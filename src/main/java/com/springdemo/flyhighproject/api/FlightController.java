package com.springdemo.flyhighproject.api;

import com.springdemo.flyhighproject.model.Flight;
import com.springdemo.flyhighproject.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class FlightController {

    private final FlightService flightService;

    @GetMapping("/flight")
    public Flight getFlight() {
        return flightService.getFlight();
    }
}
