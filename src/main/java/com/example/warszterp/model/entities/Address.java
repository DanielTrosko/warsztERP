package com.example.warszterp.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String street;
    @Column(name = "house_number", nullable = false)
    private Integer houseNumber;
    @Column(name = "apartment_no")
    private Integer apartmentNumber;
    @Column(nullable = false)
    private String city;
    @Column(name = "postal_code", nullable = false)
    private String postCode;

}
