package com.springdemo.flyhighproject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime takeOffDate;

    private LocalDateTime touchdownDate;

    //public Flight(){}

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
