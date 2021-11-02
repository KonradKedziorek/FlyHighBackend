package com.springdemo.flyhighproject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
@Entity
@Getter
@Setter

@ToString

public class Employee extends  User{

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")


    private int positionEmployee;
    private int workSinceEmployee;

}
