package com.springdemo.flyhighproject.Ticket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int seatNumber;
    private Long planeId;
    private Double price;
    private String destinationAirport;
    private String takeOffPlaceAirport;
    private Long planeClassId;

}
