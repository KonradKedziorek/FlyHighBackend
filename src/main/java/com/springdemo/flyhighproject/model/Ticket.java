package com.springdemo.flyhighproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int seatNumber;
    private double price;
    private String destinationAirport;
    private String takeOffPlaceAirport;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="plane_id", nullable=false)
    private Plane plane;

    @ManyToOne
    @JoinColumn(name="planeClass_id", nullable=false)
    private PlaneClass planeClass;

}
