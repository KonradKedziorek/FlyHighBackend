package com.springdemo.flyhighproject.payload;

import com.springdemo.flyhighproject.config.validator.UniqueBankAccount;
import com.springdemo.flyhighproject.config.validator.UniqueEmail;
import com.springdemo.flyhighproject.config.validator.UniquePhoneNumber;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
public class EditDataRequest {

    @NotEmpty(message = "Pole 'Imię' nie może być puste")
    private String name;

    private String middleName;

    @NotEmpty(message = "Pole 'Nazwisko' nie może być puste")
    private String surname;

    @NotEmpty(message = "Pole 'Państwo' nie może być puste")
    private String country;

    @NotEmpty(message = "Pole 'miasto' nie może być puste")
    private String city;

    @NotEmpty(message = "Pole 'Ulica' nie może być puste")
    private String street;

    @NotEmpty(message = "Pole 'Email' nie może być puste")
    @Email(message = "Niepoprawny email")
    @UniqueEmail(message = "Ten email został już podany przez innego użytkownika")
    private String email;

    @NotEmpty(message = "Pole 'Numer konta bankowego' nie może być puste")
    @UniqueBankAccount(message = "Istnieje użytkownik z podanym kontem bankowym")
    @Size(min=26, max=26, message="Numer konta musi składać się z 26 cyfr")
    private String bankAccount;

    @NotEmpty(message = "Pole 'Numer telefonu' nie może być puste")
    @Size(max = 15, min = 7, message = "Numer telefonu powinen posiadać od 7 do 15 cyfr")
    @UniquePhoneNumber(message = "Ten numer telefonu już istnieje w bazie")
    private String phoneNumber;

    @NotEmpty(message = "Pole 'Numer mieszkania/domu' nie może być puste")
    private String houseNumber;

    @NotEmpty(message = "Pole 'Kod pocztowy' nie może być puste")
    private String zipCode;

    public EditDataRequest(String name, String middleName, String surname, String country, String city, String street, String email, String phoneNumber, String houseNumber, String zipCode, String bankAccount) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.street = street;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.bankAccount = bankAccount;
    }
}
