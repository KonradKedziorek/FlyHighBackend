package com.springdemo.flyhighproject.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String pesel;
    public String name;
    public String middleName;
    public String surname;
    public String bankAccount;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @OneToOne(mappedBy = "user")
    private Traveler traveler;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    @OneToMany(mappedBy= "user")
    private Set<Ticket> tickets;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", employee=" + employee +
                ", traveler=" + traveler +
                ", account=" + account +
                ", address=" + address +
                ", card=" + card +
                ", tickets=" + tickets +
                '}';
    }
}
