package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findById(long id);
    Employee deleteById(long id);
}
