package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {

Traveler findByCardNumber(long cardNumber);
Traveler findById(long id);
Traveler deleteById(long id);
Traveler deleteByCardNumber(long cardNumber);
}
