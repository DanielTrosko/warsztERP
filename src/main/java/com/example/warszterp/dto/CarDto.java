package com.example.warszterp.dto;

import com.example.warszterp.model.entities.CarType;
import com.example.warszterp.model.entities.Fuel;
import com.example.warszterp.model.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString
public class CarDto {

    private Long id;
    private Fuel fuel;
    private String make;
    private String model;
    private Integer year;
    private CarType type;
    private String plateNumber;
    private String vinNo;
    private User owner;

}
