package com.springdemo.flyhighproject.api;

import com.springdemo.flyhighproject.model.Airport;
import com.springdemo.flyhighproject.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/SearchFly")
    public Airport getAirport() throws IOException {
        return airportService.getAirport();
    }
}
