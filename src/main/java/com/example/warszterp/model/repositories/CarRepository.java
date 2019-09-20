package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByPlateNumber(String plateNumber);
    List<Car> findAllByOwner_Username(String owner);
}
