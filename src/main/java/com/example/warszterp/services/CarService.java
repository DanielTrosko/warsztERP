package com.example.warszterp.services;

import com.example.warszterp.model.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CarService {

    private CarRepository carRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
