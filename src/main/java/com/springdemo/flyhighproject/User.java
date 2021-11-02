package com.springdemo.flyhighproject;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@MappedSuperclass
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")


    public int name;
    public int surname;
    public int login;
    public int password;
    public int phoneNumber;
    public int email;


}
