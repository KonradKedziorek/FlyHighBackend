package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findById(long id);
    Flight deleteById(long id);

    Flight findByTakeOffDate(LocalDate date);
    Flight findByTouchdownDate(LocalDate date);
    Flight findByTakeOffAirport(Airport airport);
    Flight findByTouchdownAirport(Airport airport);
    Flight findByPlane(Plane plane);

}
