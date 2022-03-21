package com.springdemo.flyhighproject;

import com.springdemo.flyhighproject.api.EmailController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@EntityScan
@SpringBootApplication
@Slf4j
public class FlyHighProjectApplication implements CommandLineRunner {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FlyHighProjectApplication.class, args);

        /*URL url = new URL("https://api.duffel.com/air/airports?limit=5");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        http.setRequestProperty("Accept-Encoding", "gzip");
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Duffel-Version", "beta");
        http.setRequestProperty("Authorization", "Bearer duffel_test_Rmi5mLsXEIzudveaH67TScVC0zkc6HlyIucDww7RQ0P");

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();*/

    }

    @Override
    public void run(String... args) throws Exception {

    }
}