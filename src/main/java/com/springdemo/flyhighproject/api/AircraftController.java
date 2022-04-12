package com.springdemo.flyhighproject.api;

import com.springdemo.flyhighproject.model.AircraftDTO;
import com.springdemo.flyhighproject.model.AirportDTO;
import com.springdemo.flyhighproject.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/SearchAircrafts")
    public ArrayList<AircraftDTO> getAircrafts() throws IOException {
        return aircraftService.getAircrafts();
    }
}
