package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Flight;
import com.springdemo.flyhighproject.model.Ticket;
import com.springdemo.flyhighproject.model.User;
import com.springdemo.flyhighproject.repo.FlightRepository;
import com.springdemo.flyhighproject.repo.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class FlightService {

    private RestTemplate restTemplate = new RestTemplate();

    public final FlightRepository flightRepository;

    public final TicketRepository ticketRepository;

    public FlightService(FlightRepository flightRepository, TicketRepository ticketRepository) {
        this.flightRepository = flightRepository;
        this.ticketRepository = ticketRepository;
    }

    //public void createFlight(Flight flight){ flightRepository.save(flight);}
    public Flight getFlight() {
        String response = restTemplate.getForObject("https://api.duffel.com/air/offer_requests?return_offers=false", String.class);
        log.info(response);
        return null;
    }

    public List<String> getEmailsOfPassengers(long flightId){
        List<Ticket> tickets = ticketRepository.findAllByFlight_Id(flightId);
        List<String> emails = null;
        for(Ticket t : tickets){
            emails.add(t.getUser().getAccount().getEmail());
        }
        return emails;

    }
}
