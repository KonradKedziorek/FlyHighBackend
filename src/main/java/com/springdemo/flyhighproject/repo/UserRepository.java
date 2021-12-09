package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByPesel(long pesel);
    User findAllByName(String name);
    User findAllByMiddleName(String middleName);
    User findAllBySurname(String surname);
    User findByBankAccount(long bankAccount);
    User deleteByPesel(long pesel);
    User deleteById(long id);
    User deleteAllByName(String name);
    User deleteAllByMiddleName(String middleName);
    User deleteAllBySurname(String surname);
    User deleteByBankAccount(long bankAccount);

}
