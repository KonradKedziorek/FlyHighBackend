package com.springdemo.flyhighproject.api;

import com.springdemo.flyhighproject.model.AirportDTO;
import com.springdemo.flyhighproject.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/SearchFlight")
    public ArrayList<AirportDTO> getAirports() throws IOException {
        return airportService.getAirports();
    }
}
