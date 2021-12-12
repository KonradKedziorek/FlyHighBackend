package com.springdemo.flyhighproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numberOfSeats;
    private long planeClassId;

    @OneToMany(mappedBy="plane")
    private Set<Ticket> tickets;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "plane_planeClass",
            joinColumns = @JoinColumn(name = "plane_id"),
            inverseJoinColumns = @JoinColumn(name = "planeClass_id")
    )
    private Set<PlaneClass> planeClasses = new HashSet<>();

    @ManyToMany(mappedBy = "planes")
    Set<Airport> airports;

    @OneToOne(mappedBy = "plane")
    private Flight flight;
}
