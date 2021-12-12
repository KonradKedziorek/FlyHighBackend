package com.springdemo.flyhighproject.repo;

import com.springdemo.flyhighproject.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
    Plane findById(long id);
    Plane findAllByNumberOfSeats(int numberOfSeats);
    Plane findAllByPlaneClassId(long planeClassId);
    Plane deleteById(long id);
    Plane deleteAllByNumberOfSeats(int numberOfSeats);
    Plane deleteAllByPlaneClassId(long planeClassId);
}
