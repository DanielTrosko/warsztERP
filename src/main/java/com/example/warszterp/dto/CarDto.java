package com.example.warszterp.dto;

import com.example.warszterp.model.entities.CarType;
import com.example.warszterp.model.entities.Fuel;
import com.example.warszterp.model.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
public class CarDto {

    private Long id;
    private Fuel fuel;
    @NotBlank(message = "pole jest wymagane")
    private String make;
    @NotBlank(message = "pole jest wymagane")
    private String model;
    @NotNull(message = "pole jest wymagane")
    private Integer year;
    private CarType type;
    @NotBlank(message = "pole jest wymagane")
    private String plateNumber;
    @NotBlank(message = "pole jest wymagane")
    private String vinNo;
    private User owner;

}
