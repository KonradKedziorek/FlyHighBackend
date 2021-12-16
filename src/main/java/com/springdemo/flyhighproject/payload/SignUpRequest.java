package com.springdemo.flyhighproject.payload;

import com.springdemo.flyhighproject.config.validator.UniqueUsername;
import lombok.*;

import javax.validation.constraints.NotEmpty;

/**
 *
 {
        "username": "user1",
        "password": "password",
        "phoneNumber": "444555666",
        "email": "email@gmail.com",
        "pesel": "99025400415",
        "name": "name1",
        "middleName": "middleName1",
        "surname": "surname1",
        "bankAccount": "",
        "country": "Polska",
        "city": "Białystok",
        "street": "Zwierzyniecka",
        "houseNumber": "21",
        "zipCode": "18-585"
 }
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpRequest {
    @NotEmpty(message = "Username nie może być pusty")
    @UniqueUsername(message="Istnieje użytkownik o podanej nazwie")
    private String username;
    @NotEmpty(message = "Password nie może być puste")
    private String password;
    private String phoneNumber;
    private String email;
    private long pesel;
    private String name;
    private String middleName;
    private String surname;
    private long bankAccount;
    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String zipCode;
}
