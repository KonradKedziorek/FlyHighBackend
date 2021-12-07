package com.springdemo.flyhighproject;

import com.springdemo.flyhighproject.repo.AccountRepository;
import com.springdemo.flyhighproject.repo.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@EntityScan
@SpringBootApplication
public class FlyHighProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyHighProjectApplication.class, args);
    }

    /*
    @Bean
    //Nie wiem czy tutaj trzeba wszystkie repo na raz w jednym CommandLinerze dać, czy do każdego repo oddzielny
    commandLineRunner deklarować
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, AddressRepository addressRepository) {
        return args -> {

        };
    }
    */
}
