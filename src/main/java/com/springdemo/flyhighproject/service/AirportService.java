package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.api.AirportController;
import com.springdemo.flyhighproject.model.Airport;
import com.springdemo.flyhighproject.model.Flight;
import com.springdemo.flyhighproject.repo.AirportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

@Service
@Slf4j
public class AirportService {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Airport getAirport() throws IOException {
        /*String response = restTemplate.getForObject("https://api.duffel.com/air/airports?limit=5", String.class);
        log.info(response);*/
        URL url = new URL("https://api.duffel.com/air/airports?limit=5");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        //http.setRequestProperty("Accept-Encoding", "gzip"); ten header zwraca skompresowane dane, jeżeli będziemy wiedzieli jak je zdekomprsować i chcieli to można go przywrócić
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Duffel-Version", "beta");
        http.setRequestProperty("Authorization", "Bearer duffel_test_Rmi5mLsXEIzudveaH67TScVC0zkc6HlyIucDww7RQ0P");
        http.getInputStream();
        http.connect();
        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());

        final BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            log.info(line);
        }
        http.disconnect();
        return null;
    }
}
