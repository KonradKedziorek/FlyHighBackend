package com.springdemo.flyhighproject.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String middleName;
    public String surname;
    public Long accountId;
    public Long addressId;
    public Long bankAccount;

}
