package com.example.warszterp.mapper;

import com.example.warszterp.dto.AcceptanceDataDto;
import com.example.warszterp.dto.CarDto;
import com.example.warszterp.model.entities.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    public static CarDto toDto(Car car){

        CarDto carDTO = new CarDto();
        carDTO.setFuel(car.getFuel());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setYear(car.getYear());
        carDTO.setId(car.getId());
        carDTO.setOwner(car.getOwner());
        carDTO.setPlateNumber(car.getPlateNumber());
        carDTO.setType(car.getType());
        carDTO.setVinNo(car.getVinNo());

        return carDTO;
    }

    public static Car toEntity(CarDto carDto){

        Car car = new Car();

        car.setFuel(carDto.getFuel());
        car.setMake(carDto.getMake());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        car.setId(carDto.getId());
        car.setOwner(carDto.getOwner());
        car.setPlateNumber(carDto.getPlateNumber());
        car.setType(carDto.getType());
        car.setVinNo(carDto.getVinNo());

        return car;
    }


    public static AcceptanceDataDto entityToAcceptanceData(Car car) {
        AcceptanceDataDto data = new AcceptanceDataDto();
        data.setFuel(car.getFuel());
        data.setMake(car.getMake());
        data.setModel(car.getModel());
        data.setPlateNumber(car.getPlateNumber());
        data.setType(car.getType());
        data.setVinNo(car.getVinNo());
        data.setYear(car.getYear());
        data.setCarId(car.getId());
        data.setUserId(car.getOwner().getId());

        return data;

    }

    public static AcceptanceDataDto entityToAcceptanceData(AcceptanceDataDto data, Car car) {
        data.setFuel(car.getFuel());
        data.setMake(car.getMake());
        data.setModel(car.getModel());
        data.setPlateNumber(car.getPlateNumber());
        data.setType(car.getType());
        data.setVinNo(car.getVinNo());
        data.setYear(car.getYear());
        data.setCarId(car.getId());
        data.setUserId(car.getOwner().getId());
        return data;

    }

    public static Car acceptanceDataToEntity(AcceptanceDataDto data) {
        Car car = new Car();
        car.setFuel(data.getFuel());
        car.setMake(data.getMake());
        car.setModel(data.getModel());
        car.setPlateNumber(data.getPlateNumber());
        car.setType(data.getType());
        car.setVinNo(data.getVinNo());
        car.setYear(data.getYear());
        car.setId(data.getCarId());
        return car;
    }

    public static List<CarDto> toDtoList(List<Car> list){
        return list.stream().map(car -> toDto(car)).collect(Collectors.toList());
    }
}
