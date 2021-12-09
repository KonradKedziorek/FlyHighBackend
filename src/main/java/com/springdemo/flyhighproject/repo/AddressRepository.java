package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(long id);
    Address findAllByCity(String city);
    Address findAllByCountry(String country);
    Address findAllByStreet(String street);
    Address findAllByHouseNumber(String houseNumber);
    Address findAllByZipCode(String zipCode);
    Address deleteById(long id);
    Address deleteAllByCity(String city);
    Address deleteAllByCountry(String country);
    Address deleteAllByStreet(String street);
    Address deleteAllByHouseNumber(String houseNumber);
    Address deleteAllByZipCode(String zipCode);
}
