package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.PlaneClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneClassRepository extends JpaRepository<PlaneClass, Long> {
}
