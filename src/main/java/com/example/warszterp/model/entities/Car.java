package com.example.warszterp.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank
    private String mark;
    @Column
    @NotBlank
    private String model;
    @Column
    @NotNull
    private Integer year;
    @Column
    @NotBlank
    private Fuel fuel;
}
