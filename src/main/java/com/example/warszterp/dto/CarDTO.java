package com.example.warszterp.dto;

import com.example.warszterp.model.entities.Fuel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CarDTO {

    @NotBlank
    private String mark;

    @NotBlank
    private String model;

    @NotBlank
    private Integer year;


    private Fuel fuel;

}
