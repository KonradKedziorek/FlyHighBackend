package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findById(long id);
    Card findByCardNumber(long cardNumber);
    Card findAllByValidThru(String validThru);
    Card deleteById(long id);
    Card deleteByCardNumber(long cardNumber);
    Card deleteAllByValidThru(String validThru);
    
}
