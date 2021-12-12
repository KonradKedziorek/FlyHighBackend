package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
   Account findById(long id);
   Account findByUsername(String username);
   Account findByPhoneNumber(String phoneNumber);
   Account findByEmail(String email);
   Account deleteById(long id);
   Account deleteByUsername(String username);
   Account deleteByPhoneNumber(String phoneNumber);
   Account deleteByEmail(String email);
}
