package com.springdemo.flyhighproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long cardNumber;
    private String validThru;
    private int CVC;

    @OneToOne(mappedBy = "card")
    private User user;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", validThru='" + validThru + '\'' +
                ", CVC=" + CVC +
                ", user=" + user +
                '}';
    }
}
