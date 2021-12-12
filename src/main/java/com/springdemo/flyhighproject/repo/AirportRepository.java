package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findById(long id);
    Airport findAllByCity(String city);
    Airport findAllByCountry(String country);
    Airport findByName(String name);
    Airport deleteById(long id);
    Airport deleteAllByCity(String city);
    Airport deleteAllByCountry(String country);
    Airport deleteByName(String name);
}
