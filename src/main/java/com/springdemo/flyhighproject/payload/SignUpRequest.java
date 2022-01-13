package com.springdemo.flyhighproject.payload;

import com.springdemo.flyhighproject.config.validator.UniqueEmail;
import com.springdemo.flyhighproject.config.validator.UniquePhoneNumber;
import com.springdemo.flyhighproject.config.validator.UniqueUsername;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

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
    @NotEmpty(message = "Pole 'Hasło' nie może być puste")
    private String password;
    @NotEmpty(message = "Pole 'Numer telefonu' nie może być puste")
    @Size(max = 15, min = 7, message = "Numer telefonu powinen posiadać od 7 do 15 cyfr")
    @UniquePhoneNumber(message = "Ten numer telefonu już istnieje w bazie")
    private String phoneNumber;
    @NotEmpty(message = "Pole 'Email' nie może być puste")
    @Email(message = "Niepoprawny email")
    @UniqueEmail(message = "Ten email został już podany przez innego użytkownika")
    private String email;
    @NotEmpty(message = "Pole 'PESEL' nie może być puste")
    private String pesel;
    @NotEmpty(message = "Pole 'Imię' nie może być puste")
    private String name;
    private String middleName;
    @NotEmpty(message = "Pole 'Nazwisko' nie może być puste")
    private String surname;
    @NotEmpty(message = "Pole 'Numer konta bankowego' nie może być puste")
    private String bankAccount;
    @NotEmpty(message = "Pole 'Państwo' nie może być puste")
    private String country;
    @NotEmpty(message = "Pole 'miasto' nie może być puste")
    private String city;
    @NotEmpty(message = "Pole 'Ulica' nie może być puste")
    private String street;
    @NotEmpty(message = "Pole 'Numer mieszkania/domu' nie może być puste")
    private String houseNumber;
    @NotEmpty(message = "Pole 'Kod pocztowy' nie może być puste")
    private String zipCode;
}
