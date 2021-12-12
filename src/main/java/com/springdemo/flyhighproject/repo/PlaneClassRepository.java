package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.PlaneClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneClassRepository extends JpaRepository<PlaneClass, Long> {
    PlaneClass findById(long id);
    PlaneClass findAllByName(String name);
    PlaneClass deleteBy(long id);
    PlaneClass deleteAllByName(String name);
}
