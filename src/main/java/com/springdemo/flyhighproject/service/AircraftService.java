package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.AircraftDTO;
import com.springdemo.flyhighproject.model.AirportDTO;
import com.springdemo.flyhighproject.repo.AircraftRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Service
public class AircraftService {

    @Autowired
    AircraftRepository aircraftRepository;

    public ArrayList<AircraftDTO> getAircrafts() throws IOException {
        ArrayList<AircraftDTO> aircrafts = new ArrayList<AircraftDTO>();
        URL url = new URL("https://api.duffel.com/air/aircraft?limit=5");
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
        String line = in.readLine();
    /*while ((line = in.readLine()) != null) {
        log.info(line);
    }*/
        JSONObject obj = new JSONObject(line);
        JSONArray arr = obj.getJSONArray("data");

        for(int i = 0; i < arr.length(); i++) {
            AircraftDTO aircraftDTO = new AircraftDTO(
                    arr.getJSONObject(i).getString("iata_code"),
                    arr.getJSONObject(i).getString("id"),
                    arr.getJSONObject(i).getString("name")
            );
            aircrafts.add(aircraftDTO);
            System.out.println(aircrafts.get(i).getName());
        }
        http.disconnect();
        return null;
    }
}
