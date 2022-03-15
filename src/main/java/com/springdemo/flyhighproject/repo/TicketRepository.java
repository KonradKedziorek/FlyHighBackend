package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


   Ticket findById(long id);
   Ticket findAllByPrice(double price);
   Ticket findAllBySeatNumber(int seatNumber);
   Ticket findAllByDestinationAirportAndTakeOffPlaceAirport(String destinationAirport, String takeOffPlaceAirport);
   List<Ticket> findAllByFlight_Id(long flightId);
   Ticket deleteById(long id);
   Ticket deleteAllByPrice(double price);
   Ticket deleteAllBySeatNumber(int seatNumber);
   Ticket deleteAllByDestinationAirportAndTakeOffPlaceAirport(String destinationAirport, String takeOffPlaceAirport);


}
