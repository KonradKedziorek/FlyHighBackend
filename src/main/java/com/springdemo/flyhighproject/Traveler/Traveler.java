package com.springdemo.flyhighproject.Traveler;
import com.springdemo.flyhighproject.Person.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Traveler{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private Long cardNumber;

}