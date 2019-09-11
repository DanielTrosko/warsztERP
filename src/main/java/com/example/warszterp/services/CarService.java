package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.mapper.CarMapper;
import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Service
@Transactional
public class CarService {

    private CarRepository carRepository;

   /* @PersistenceContext
    private EntityManager entityManager;*/

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getDataAndSave(AcceptanceDataDto data, User user){

        Car car = new Car();
        car = CarMapper.acceptanceDataToEntity(data);
        car.setOwner(user);
        Car existnigCar = carRepository.findByPlateNumber(car.getPlateNumber());
        if (existnigCar == null){
           car = carRepository.save(car);
        }
        return car;
    }
}
