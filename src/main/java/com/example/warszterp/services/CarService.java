package com.example.warszterp.services;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.CarDto;
import com.example.warszterp.mapper.CarMapper;
import com.example.warszterp.model.entities.Car;
import com.example.warszterp.model.entities.User;
import com.example.warszterp.model.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Car existingCar = carRepository.findByPlateNumber(car.getPlateNumber());
        System.out.println(existingCar == null);
        if (existingCar == null){
            existingCar = carRepository.save(car);
        }
        return existingCar;
    }

         public AcceptanceDataDto getDataFromCar(AcceptanceDataDto dataDto){
            Car car = carRepository.getOne(dataDto.getCarId());
             return CarMapper.entityToAcceptanceData(dataDto ,car);
         }


    public Car getDataAndUpdate(AcceptanceDataDto data, User user){
        Car car = new Car();
        car = CarMapper.acceptanceDataToEntity(data);
        car.setOwner(user);
        return carRepository.save(car);

    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

    public List<CarDto> getAll(){
      return CarMapper.toDtoList(carRepository.findAll());
    }

    public CarDto getById(Long id){
     return  CarMapper.toDto(carRepository.findById(id).get());
    }

    public void save(CarDto dto){
        carRepository.save(CarMapper.toEntity(dto));
    }

    public void update(CarDto dto){
        carRepository.save(CarMapper.toEntity(dto));
    }
}
