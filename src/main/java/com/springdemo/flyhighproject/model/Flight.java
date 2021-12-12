package com.springdemo.flyhighproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate takeOffDate;

    private LocalDate touchdownDate;

    @OneToOne
    @JoinColumn(name = "takeOffAirport_id", referencedColumnName = "id")
    private Airport takeOffAirport;

    @OneToOne
    @JoinColumn(name = "touchdownAirport_id", referencedColumnName = "id")
    private Airport touchdownAirport;

    @OneToOne
    @JoinColumn(name = "plane_id", referencedColumnName = "id")
    private Plane plane;

    @OneToMany(mappedBy= "flight")
    private Set<Ticket> tickets;
}
