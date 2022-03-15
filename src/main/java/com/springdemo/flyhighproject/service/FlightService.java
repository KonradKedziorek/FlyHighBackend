package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Flight;
import com.springdemo.flyhighproject.model.Ticket;
import com.springdemo.flyhighproject.model.User;
import com.springdemo.flyhighproject.repo.FlightRepository;
import com.springdemo.flyhighproject.repo.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    //@Autowired
    //private FlightRepository flightRepository;
    public final FlightRepository flightRepository;

    public final TicketRepository ticketRepository;

    public FlightService(FlightRepository flightRepository, TicketRepository ticketRepository) {
        this.flightRepository = flightRepository;
        this.ticketRepository = ticketRepository;
    }

    public void createFlight(Flight flight){ flightRepository.save(flight);}

    public List<String> getEmailsOfPassengers(long flightId){
        List<Ticket> tickets = ticketRepository.findAllByFlight_Id(flightId);
        List<String> emails = null;
        for(Ticket t : tickets){
            emails.add(t.getUser().getAccount().getEmail());
        }
        return emails;
    }
}
