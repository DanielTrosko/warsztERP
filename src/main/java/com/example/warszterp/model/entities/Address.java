package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Getter @Setter
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    @NotBlank
    private String street;
    @Column
    @NotNull
    private Integer houseNumber;
    @Column
    @NotNull
    private Integer apartmentNumber;
    @Column
    @NotBlank
    private String city;
    @Column
    @NotBlank
    private String postCode;

}
