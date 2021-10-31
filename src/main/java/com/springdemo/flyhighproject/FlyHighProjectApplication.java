package com.springdemo.flyhighproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class FlyHighProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyHighProjectApplication.class, args);
    }

}
