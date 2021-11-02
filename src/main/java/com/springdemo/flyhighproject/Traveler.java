package com.springdemo.flyhighproject;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Getter
@Setter

public class Traveler extends User{

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")


    private String countryTraveler;
    private String cityTraveler;
    private String cardNumberTraveler;
    private String dateCardTraveler;
    private String CVVCardTraveler;
    private String streetTraveler;
    private String houseNumberTraveler;
    private String ZipCodeTraveler;

}