package com.springdemo.flyhighproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private User user;

}
