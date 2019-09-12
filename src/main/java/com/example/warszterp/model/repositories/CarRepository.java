package com.example.warszterp.model.repositories;

import com.example.warszterp.model.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByPlateNumber(String plateNumber);
}
